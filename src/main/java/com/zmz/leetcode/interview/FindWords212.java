package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords212 {

    // 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
    //
    //单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
    //

    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 26个字母的子节点
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        // 这道题进行dfs递归循环
        // 但是在递归时需要进行单词查找
        // 构建前缀树的目的就是方便递归时的单词查找
        // 若dfs找到了前缀树的终点，说明存在单词
        TrieNode root = buildTrieNode(words);
        Set<String> hashSet = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsHelper(board, visited, i, j, root, hashSet);
            }
        }
        return new ArrayList<>(hashSet);
    }

    private void dfsHelper(char[][] board, boolean[][] visited, int i, int j, TrieNode root, Set<String> result) {
        // 递归终止条件
        // 若找到单词存入result 同时返还
        if (root.word != null) {
            result.add(root.word);
            // 这里不能返回 因为有可能存在 eat eater 这种单词 eat被收集后，仍需要继续dfs来收集eater
//            return;
        }
        // 边界判断
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        char c = board[i][j];
        int index = c - 'a';
        // 前缀树没有找到对应字符 也返回
        if (index < 0 || index >= 26 || root.children[index] == null) {
            return;
        }
        // 找到字符了
        // 继续向下寻找
        // 避免重复查找
        visited[i][j] = true;
        // node 也需要向下
        dfsHelper(board, visited, i - 1, j, root.children[index], result);
        dfsHelper(board, visited, i + 1, j, root.children[index], result);
        dfsHelper(board, visited, i, j - 1, root.children[index], result);
        dfsHelper(board, visited, i, j + 1, root.children[index], result);

        visited[i][j] = false;


    }


    // 构建字典树
    private TrieNode buildTrieNode(String[] words) {
        // 给定字符串数组
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            // node作为index 进行next step 使用
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }


}
