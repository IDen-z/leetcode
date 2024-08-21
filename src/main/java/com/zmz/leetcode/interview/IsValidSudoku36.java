package com.zmz.leetcode.interview;

public class IsValidSudoku36 {

    //请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
    //
    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
    //
    //
    //注意：
    //
    //一个有效的数独（部分已被填充）不一定是可解的。
    //只需要根据以上规则，验证已经填入的数字是否有效即可。
    //空白格用 '.' 表示。

    public static void main(String[] args) {
        char[][] chars = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        isValidSudoku(chars);
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] x = new int[10];
            int[] y = new int[10];
            for (int j = 0; j < 9; j++) {
                char pointX = board[i][j];
                char pointY = board[j][i];
                if (pointX != '.') {
                    int p = (int) pointX - (int) ('0');
                    if (x[p] > 0) {
                        return false;
                    }
                    x[p] = p;
                }
                if (pointY != '.') {
                    int p = (int) pointY - (int) ('0');
                    if (y[p] > 0) {
                        return false;
                    }
                    y[p] = p;
                }
            }
        }

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int[] z = new int[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char point = board[i + x * 3][j + y * 3];
                        if (point != '.') {
                            int p = (int) point - (int) ('0');
                            if (z[p] > 0) return false;
                            z[p] = p;
                        }
                    }
                }
            }
        }

        return true;

    }

}
