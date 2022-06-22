package com.zmz.leetcode.tag.string2;

/**
 * 最后一个单词的长度
 */
public class LengthOfLastWord58 {

    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     * <p>
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] != ' ') {
                // 开始计数
                int index = i;
                while (index >= 0 && charArray[index] != ' ') {
                    index--;
                }
                return i - index;

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LengthOfLastWord58 lengthOfLastWord58 = new LengthOfLastWord58();
        int i = lengthOfLastWord58.lengthOfLastWord("Hello");
        System.err.println(i);


    }


}
