package com.zmz.leetcode.interview;

import java.util.*;

public class LadderLength127 {

    // 字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
    //    //
    //    //每一对相邻的单词只差一个字母。
    //    // 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
    //    //sk == endWord
    //    //给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
    //    //
    //    //
    //    //示例 1：
    //    //
    //    //输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    //    //输出：5
    //    //解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
    //    //示例 2：
    //    //
    //    //输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    //    //输出：0
    //    //解释：endWord "cog" 不在字典中，所以无法进行转换。


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // TODO 本题可以进行优化

        // 把一步转换理解成图
        // BFS遍历生成的图 找到能够变化成endWord的最小步数
        int res = 0;

        // 需要使用hashMap记录 已经变形过的word 不再进入bfs遍历


        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        Set<String> hashSet = new HashSet<>();
        hashSet.add(beginWord);
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (endWord.equals(poll)) {
                    return res;
                }
                // 继续进行变形
                for (String nextWord : wordList) {
                    if (!hashSet.contains(nextWord) && oneStepFlag(poll, nextWord)) {
                        queue.offer(nextWord);
                        hashSet.add(nextWord);
                    }
                }
            }

        }

        return 0;

    }

    private static boolean oneStepFlag(String source, String target) {
        if (source.length() != target.length()) {
            return false; // 长度不同，返回 false
        }

        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                count++;
                if (count > 1) {
                    return false; // 超过一个字符变化，返回 false
                }
            }
        }
        return count == 1; // 只有一个字符变化则返回 true
    }


}
