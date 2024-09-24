package com.zmz.leetcode.interview;

public class Solve130 {

    // 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
    //
    //连接：一个单元格与水平或垂直方向上相邻的单元格连接。
    //区域：连接所有 'O' 的单元格来形成一个区域。
    //围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
    //通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。
    //
    //
    //
    //示例 1：
    //s
    //输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
    //
    //输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]


    public void solve(char[][] board) {
        // 这道题需要反着想 因为要把包围的区域变为X
        // 分为两步骤 1、找到与边界相连的O因为这些O是不被包围的O 记录为中间态
        // 2、此时矩阵中只存在 X O * 那么剩下的O 就是需要转为X的区域，同时把*还原为O
        // 步骤1 只循环边界的
        for (int i = 0; i < board.length; i++) {
            // 遍历两个列
            if (board[i][0] == 'O') {
                dfsMethod(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfsMethod(board, i, board[0].length - 1);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            // 遍历两个列
            if (board[0][j] == 'O') {
                dfsMethod(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                dfsMethod(board, board.length - 1, j);
            }
        }

        // 步骤2 遍历图 修改状态
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfsMethod(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '*';
        dfsMethod(board, i - 1, j);
        dfsMethod(board, i + 1, j);
        dfsMethod(board, i, j - 1);
        dfsMethod(board, i, j + 1);

    }

}
