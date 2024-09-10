package com.zmz.leetcode.interview;

public class Trie208 {

    //Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
    //
    //请你实现 Trie 类：
    //
    //Trie() 初始化前缀树对象。
    //void insert(String word) 向前缀树中插入字符串 word 。
    //boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
    //boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
    //
    //
    //示例：
    //
    //输入
    //["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
    //[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
    //输出
    //[null, null, true, false, true, null, true]
    //
    //解释
    //Trie trie = new Trie();
    //trie.insert("apple");
    //trie.search("apple");   // 返回 True
    //trie.search("app");     // 返回 False
    //trie.startsWith("app"); // 返回 True
    //trie.insert("app");
    //trie.search("app");     // 返回 True


    // TODO 0 代表a  同时每一个分支 都是具有26个字母的叉
    private Trie208[] children;
    private boolean isEnd;

//    public Trie208() {
//        children = new Trie208[26];
//        isEnd = false;
//    }
//
//    public void insert(String word) {
//        for (int i = 0; i < word.length(); i++) {
//
//
//        }
//    }
//
//    public boolean search(String word) {
//
//    }
//
//    public boolean startsWith(String prefix) {
//
//    }


}
