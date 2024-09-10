package com.zmz.leetcode.hot;


/**
 * 实现前缀树
 */
public class Trie208 {

    /**
     * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
     * <p>
     * 请你实现 Trie 类：
     * <p>
     * Trie() 初始化前缀树对象。
     * void insert(String word) 向前缀树中插入字符串 word 。
     * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
     * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false
     */


    /**
     * 其实这道题就是一个26缀树 每个节点都可以向外延申26个分叉 同时每个节点也需要一个Boolean的标志位
     * 来记录是否是单词结尾
     */
    private Trie208[] childrenNodes;
    private boolean endFlag;

    public Trie208() {
        // 初始化一个Node节点
        childrenNodes = new Trie208[26];
        endFlag = false;
    }

    public void insert(String word) {
        // 遍历子节点 如果有就只改变endFlag  没有的话就新增子节点
        Trie208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.childrenNodes[index] == null) {
                // 该节点新增对应 char 的子节点
                node.childrenNodes[index] = new Trie208();
            }
            if (i == word.length() - 1) {
                // 到达单词末尾
                node.childrenNodes[index].endFlag = true;
            }
            // 这一步非常重要 这类似于树的下一步
            node = node.childrenNodes[index];
        }
    }

    public boolean search(String word) {
        // 查找 根据节点查找
        Trie208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.childrenNodes[index] == null) {
                return false;
            }
            // TODO 这里是找完整单词 而不是前缀
            if (i == word.length() - 1 && !node.childrenNodes[index].endFlag) {
                return false;
            }
            // 这一步非常重要 这类似于树的下一步
            node = node.childrenNodes[index];
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        // 查找 根据节点查找
        Trie208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.childrenNodes[index] == null) {
                return false;
            }
            // 这一步非常重要 这类似于树的下一步
            node = node.childrenNodes[index];
        }
        return true;
    }

    public static void main(String[] args) {

        Trie208 obj = new Trie208();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_3 = obj.startsWith("app");
    }

}
