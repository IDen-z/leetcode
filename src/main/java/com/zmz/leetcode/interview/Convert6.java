package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class Convert6 {

    // 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
    //
    //比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
    //
    //P   A   H   N
    //A P L S I I G
    //Y   I   R
    //之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
    //
    //请你实现这个将字符串进行指定行数变换的函数：
    //
    //string convert(string s, int numRows);
    //
    //
    //示例 1：
    //
    //输入：s = "PAYPALISHIRING", numRows = 3
    //输出："PAHNAPLSIIGYIR"
    //示例 2：
    //输入：s = "PAYPALISHIRING", numRows = 4
    //输出："PINALSIGYAHRPI"
    //解释：
    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I
    //示例 3：
    //
    //输入：s = "A", numRows = 1
    //输出："A"

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        // 模拟N字的模拟
        // 初始化numRows个数组用来存放每一层的字符
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        // 开始遍历字符串
        // 忘记中间的空格 先向下填充 到头后逆行即可
        // pos用来记录加到哪个层级的数组中
        int pos = 0;
        // flag 表示逆行标志
        int flag = -1;
        for (char c : s.toCharArray()) {
            list.get(pos).append(c);
            if (pos == 0 || pos == numRows - 1) {
                // 到头了 开始逆行
                flag = -flag;
            }
            pos += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) res.append(sb);
        return res.toString();


    }


}
