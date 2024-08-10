package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class FullJustify68 {
    // 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
    //
    //你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
    //
    //要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
    //
    //文本的最后一行应为左对齐，且单词之间不插入额外的空格。
    //
    //注意:
    //
    //单词是指由非空格字符组成的字符序列。
    //每个单词的长度大于 0，小于等于 maxWidth。
    //输入单词数组 words 至少包含一个单词。
    //
    //
    //示例 1:
    //
    //输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    //输出:
    //[
    //   "This    is    an",
    //   "example  of text",
    //   "justification.  "
    //]
    //示例 2:
    //
    //输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
    //输出:
    //[
    //  "What   must   be",
    //  "acknowledgment  ",
    //  "shall be        "
    //]
    //解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
    //     因为最后一行应为左对齐，而不是左右两端对齐。
    //     第二行同样为左对齐，这是因为这行只包含一个单词。
    //示例 3:
    //
    //输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
    //输出:
    //[
    //  "Science  is  what we",
    //  "understand      well",
    //  "enough to explain to",
    //  "a  computer.  Art is",
    //  "everything  else  we",
    //  "do                  "
    //]

    public static void main(String[] args) {
        String[] s = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        fullJustify(s, 16);
    }

    //    public static List<String> fullJustify(String[] words, int maxWidth) {
//        // 按照需求模拟
//        // 顺序填充words到每一行
//        List<String> ans = new ArrayList<String>();
//        // right 用来记录已经处理到哪个单词了
//        int right = 0;
//        while (true) {
//            // 一直循环模拟 直到最后一行
//
//            // 先计算出每一行最多能有多少个单词
//            // left 用来记录当前行是从哪个单词开始的
//            int left = right;
//            // 用来记录当前行单词的长度一共是多长
//            // 这里的 right-left的值需要理解 right 是当前行数的所有单词下标 left是当前行开始的单词下标
//            // 做差其实就是当前行有多少个单个空格
//            // 每个单词之间要保证有一个空格
//            int sumLen = 0;
//            // 每一行要恰好有maxWidth 个字符
//            while (right < words.length && sumLen + words[right].length() + right - left <= maxWidth) {
//                sumLen += words[right].length();
//                right++;
//            }
//
//
//            // 当处理到最后一个单词时 当前行是最后一行 right ++ 后
//            if (right == words.length) {
//                StringBuffer sb = join(words, left, words.length, " ");
//                // blank 方法为填充空格
//                sb.append(blank(maxWidth - sb.length()));
//                ans.add(sb.toString());
//                return ans;
//            }
//
//            // 因为right 已经自增 那么right已经变成了下一行的开始
//            // 上一行的单词个数
//            int numWords = right - left;
//            int numSpaces = maxWidth - sumLen;
//
//            // 当前行只有一个单词：该单词左对齐，在行末填充剩余空格
//            if (numWords == 1) {
//                StringBuffer sb = new StringBuffer(words[left]);
//                sb.append(blank(numSpaces));
//                ans.add(sb.toString());
//                continue;
//            }
//
//            // 当前行不只一个单词
//            int avgSpaces = numSpaces / (numWords - 1);
//            int extraSpaces = numSpaces % (numWords - 1);
//            StringBuffer sb = new StringBuffer();
//            sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1))); // 拼接额外加一个空格的单词
//            sb.append(blank(avgSpaces));
//            sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces))); // 拼接其余单词
//            ans.add(sb.toString());
//
//
//        }
//
//
//    }
//
//    // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
//    public static StringBuffer join(String[] words, int left, int right, String sep) {
//        StringBuffer sb = new StringBuffer(words[left]);
//        for (int i = left + 1; i < right; ++i) {
//            sb.append(sep);
//            sb.append(words[i]);
//        }
//        return sb;
//    }
//
    // blank 返回长度为 n 的由空格组成的字符串
    public static String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }
//

    public static List<String> fullJustify(String[] words, int maxWidth) {
        // 通过模拟解决问题
        // 首先计算每一行最多可以填充多少个单词 同时单词之间最少保留一个空格
        // 其次判断当前行的情况
        // 1、处理到最后一个单词 且当前行是最后一行 跳出循环 同时单词在最左边开始，每个单词之间保留一个空格，后面全部填充空格至最大长度
        // 2、当前行不是最后一行分为两种情况
        //    第一种当前行只有一个单词 那么后面填充空格就行
        //    第二种 当前行有多个单词 首先计算当前行有多少个单词numWords
        //          在计算当前行应该填充多少个空格 numSpaces
        //          需要从左到右填充 分配空格 numSpaces / numWords-1 = 每个单词最少填充的空格
        //          extra=numSpaces % numWords-1 为需要额外填充的空格 也就是说 从单词左开始 顺序往后多加一个空格 extra就是间隔的数目
        List<String> res = new ArrayList<>();
        int right = 0; // right 表示结束单词的下标
        while (true) {
            // 开始一行一行处理
            int left = right; // left 记录每行单词开始的下标
            int sumLen = 0; // 记录每行字符总数
            while (right < words.length && words[right].length() + sumLen + right - left <= maxWidth) {
                sumLen += words[right].length();
                right++;
            }

            if (right == words.length) {
                // 最后一行是不需考虑左空格和右空格谁多的问题的
                // 因为无需两端对齐 只需要左对齐
                // 先把left 到 right-1的单词进行填充 后面补空格即可
                StringBuilder sb = new StringBuilder();
                sb.append(words[left]);
                for (int i = left + 1; i < right; i++) {
                    sb.append(' ');
                    sb.append(words[i]);
                }
                // 剩下的补空格
                int length = sb.length();
                for (int j = 0; j < maxWidth - length; j++) {
                    sb.append(' ');
                }
                res.add(sb.toString());
                return res;
            }
            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            if (numWords == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(words[left]);
                int length = sb.length();
                for (int j = 0; j < maxWidth - length; j++) {
                    sb.append(' ');
                }
                res.add(sb.toString());
                continue;
            }
            // aaa  bbb ccc
            // 普通行
            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            StringBuilder sb = new StringBuilder();
            sb.append(words[left]);
            for (int i = left + 1; i < left + extraSpaces + 1; i++) {
                int index = 0;
                while (index < avgSpaces) {
                    sb.append(' ');
                    index++;
                }
                sb.append(' ');
                sb.append(words[i]);
            }
            int index2 = 0;
            while (index2 < avgSpaces) {
                sb.append(' ');
                index2++;
            }
            sb.append(words[left + extraSpaces + 1]);
            for (int i = left + extraSpaces + 1 + 1; i < right; i++) {
                int index = 0;
                while (index < avgSpaces) {
                    sb.append(' ');
                    index++;
                }
                sb.append(words[i]);
            }
            res.add(sb.toString());

        }


    }


}
