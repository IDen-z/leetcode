package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindWords212Copy {

    // 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
    //
    //单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
    //
    class Trie {
        // 前缀树两种方式 一种 26长度的数组 一种hash表
        Trie[] children = new Trie[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        // 根据图得方向来查找words的字符数组
        // 如果不用前缀树的话 每次递归到下一个字符时，需要遍历每个words数组的 工作量巨大
        // 因此单词检索通过构造前缀树来减轻任务量
        Trie root = buildTrie(words);
        // 递归所需对象
        HashSet<String> set = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 每一个节点 都作为开始节点遍历一次
                dfsHelper(board, i, j, set, visited, root);
            }
        }

        return new ArrayList<>(set);
    }


    private void dfsHelper(char[][] board, int i, int j, HashSet<String> set, boolean[][] visited, Trie node) {
        // 递归终止条件
        if (node.word != null) {
            // 不为null时 加入结果集
            set.add(node.word);
        }
        // 边界超越 或已经遍历 中断
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        // 字符不存在 中断
        char c = board[i][j];
        int index = c - 'a';
        if (node.children[index] == null) {
            return;
        }
        // 当前字符标记为已遍历
        visited[i][j] = true;
        dfsHelper(board, i - 1, j, set, visited, node.children[index]);
        dfsHelper(board, i + 1, j, set, visited, node.children[index]);
        dfsHelper(board, i, j - 1, set, visited, node.children[index]);
        dfsHelper(board, i, j + 1, set, visited, node.children[index]);
        // 必须四步走完才算是当前节点找完 当前节点找完要回溯
        visited[i][j] = false;

    }

    /**
     * 构建前缀树
     */
    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (Character c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            // 前缀树到最后了
            node.word = word;
        }
        return root;

    }


}
