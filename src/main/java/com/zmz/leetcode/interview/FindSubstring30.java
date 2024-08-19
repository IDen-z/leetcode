package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring30 {

//     给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
//
//     s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
//
//    例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
//    返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "barfoothefoobarman", words = ["foo","bar"]
    //输出：[0,9]
    //解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
    //子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
    //子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
    //输出顺序无关紧要。返回 [9,0] 也是可以的。
    //示例 2：
    //
    //输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
    //输出：[]
    //解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
    //s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
    //所以我们返回一个空数组。
    //示例 3：
    //
    //输入：s = "barfoofoobsarthefoobarman", words = ["bar","foo","the"]
    //输出：[6,9,12]
    //解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
    //子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
    //子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
    //子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。

    public List<Integer> findSubstring(String s, String[] words) {

        // 一个单词的长度
        int wordLength = words[0].length();
        // 一个判断字符串的总长度
        int totalLength = wordLength * words.length;
        List<Integer> res = new ArrayList<>();
        // 用hash表来记录当前单词是否存在
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // 滑动窗口 每次滑动一个单词的距离（每次都会把整个字符串s滑动完）
        // 但是每个单词的开始下标不同会导致有不同的滑动结果
        // 因此只需要对wordLength进行遍历 保证每种偏移都在考虑范围内
        for (int i = 0; i < wordLength; i++) {
            // 因此只需要对wordLength进行遍历 例如words = ["bar","foo","the"] 则只需要循环三次
            // 开始滑动
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> currentMap = new HashMap<>();
            while (right <= s.length() - wordLength) {
                // 右指针遍历到字符串的最后，当不足一个单词时终止循环
                // 使用一个临时hash表记录单词的出现个数，当right指针跑了一个完整串联子串的长度
                // 且hash表的记录数符合题意时，记录左下标到结果集中
                String str = s.substring(right, right + wordLength);
                // 每次移动一个单词的长度
                right += wordLength;

                if (wordMap.containsKey(str)) {
                    currentMap.put(str, currentMap.getOrDefault(str, 0) + 1);
                    count++;

                    // 这个while循环
                    while (currentMap.get(str) > wordMap.get(str)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == words.length) {
                        res.add(left);
                    }
                } else {
                    currentMap.clear();
                    count = 0;
                    left = right;
                }

            }


        }
        return res;


    }


    public List<Integer> findSubstring_gpt(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        if (s.length() < totalLength) {
            return result;
        }

        // 使用Map存储words中每个单词出现的次数
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // 遍历s的前totalLength个字符
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            int count = 0;
            Map<String, Integer> currentMap = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordMap.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    currentMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        findSubstring_self("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"});
    }

    public static List<Integer> findSubstring_self(String s, String[] words) {
        // 此题为标准的滑动窗口
        // 每个单词的长度为滑块滑动的距离
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        List<Integer> res = new ArrayList<>();
        // 滑块每次滑动单词的长度，但是单词的初始位置不同可能导致结果不同
        // 循环单个单词的长度 保证不同的偏移量即可

        // 使用一个hash表记录单词和每个单词出现的次数
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            // 左指针
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> currentMap = new HashMap<>();
            // right 指针每次开始滑动一个单词的距离
            // 《= 是因为下面的subString是左闭右开
            while (right + wordLength <= s.length()) {
                String str = s.substring(right, right + wordLength);
                right += wordLength;

                // 如果滑块的单词包含在wordMap中，说明这个单词可以构造成一个目标字符串
                // 继续循环
                if (wordMap.containsKey(str)) {
                    // 计数+1
                    count++;
                    // 放入当前计数map
                    currentMap.put(str, currentMap.getOrDefault(str, 0) + 1);

                    // 滑动窗口的模板 不满足的条件时 左指针也要动
                    while (wordMap.get(str) < currentMap.get(str)) {
                        // 此时说明窗口中存在了两个重复的单词，但是原单词字符串只能有一个
                        // 向左滑动 直到满足条件
                        count--;
                        String leftWord = s.substring(left, left + wordLength);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        left += wordLength;
                    }

                    // yidingyao
                    if (count == words.length) {
                        // 说明右指针已经遍历了word.length次 窗口已经有了足够的单词数量
                        res.add(left);
                    }

                } else {
                    // 否则放弃当前滑块，左指针 left从right的位置重新开始
                    left = right;
                    count = 0;
                    currentMap.clear();
                }
            }


        }

        return res;
    }

}
