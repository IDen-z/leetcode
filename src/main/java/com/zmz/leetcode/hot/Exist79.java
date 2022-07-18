package com.zmz.leetcode.hot;

/**
 * 单词搜索
 */
public class Exist79 {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() <= 0 || word.length() > board.length * board[0].length) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (checkFlag(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkFlag(char[][] board, int i, int j, String word) {
        int[][] flag = new int[board.length][board[0].length];
        // 回溯查找word
        if (dfs2(board, i, j, word, 0, flag)
        ) return true;
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index, int flag) {
        /**
         * 这是第一版写法
         * 第一版写法最大的问题就是会走回头路
         * 比如ABCB这种  遍历到C时就会回头找B 进而报错\、、
         * 因此这里新增一个flag避免回头
         *
         * 第二版写法还是有问题
         * 加了flag以后可以避免上一步的回头
         * 但是无法避免贪吃蛇一样的环形回头
         *
         */
        // 递归终止条件
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || word.charAt(index) != board[i][j]) {
            return false;
        }
        if (flag != 1 && dfs(board, i + 1, j, word, index + 1, 0)) {
            return true;
        }
        if (flag != 0 && dfs(board, i - 1, j, word, index + 1, 1)) {
            return true;
        }
        if (flag != 3 && dfs(board, i, j + 1, word, index + 1, 2)) {
            return true;
        }
        if (flag != 2 && dfs(board, i, j - 1, word, index + 1, 3)) {
            return true;
        }
        return false;
    }

    public boolean dfs2(char[][] board, int i, int j, String word, int index, int[][] flag) {
        /**
         * 这是第一版写法
         * 第一版写法最大的问题就是会走回头路
         * 比如ABCB这种  遍历到C时就会回头找B 进而报错\、、
         * 因此这里新增一个flag避免回头
         *
         * 第二版写法还是有问题
         * 加了flag以后可以避免上一步的回头
         * 但是无法避免贪吃蛇一样的环形回头
         *
         * 第三版终于ac
         * 标记了一个矩阵 避免重复
         */
        // 递归终止条件
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || word.charAt(index) != board[i][j] || flag[i][j] == 1) {
            return false;
        }
        flag[i][j] = 1;
        if (dfs2(board, i + 1, j, word, index + 1, flag)) {
            return true;
        }
        if (dfs2(board, i - 1, j, word, index + 1, flag)) {
            return true;
        }
        if (dfs2(board, i, j + 1, word, index + 1, flag)) {
            return true;
        }
        if (dfs2(board, i, j - 1, word, index + 1, flag)) {
            return true;
        }
        flag[i][j] = 0;
        return false;
    }


    public static void main(String[] args) {
//        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = new char[][]{{'a', 'a'}, {'a', 'a'}};
        char[][] board = new char[][]{{'a', 'a', 'b', 'a', 'a', 'b'}, {'a', 'a', 'b', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a', 'b', 'a'}, {'b', 'a', 'b', 'b', 'a', 'b'}
                , {'a', 'b', 'b', 'a', 'b', 'a'}, {'b', 'a', 'a', 'a', 'a', 'b'}
        };
        Exist79 exist79 = new Exist79();
        boolean f = exist79.exist(board, "bbbaabbbbbab");
        System.err.println(f);
    }
}