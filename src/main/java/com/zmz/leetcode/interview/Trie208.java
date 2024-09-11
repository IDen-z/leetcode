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

    // 前缀树主要就是每个字符作为一个节点 最终组成树状结构
    // 同时nextNode作为属性值放在节点中
    private Trie208[] nextNode;
    // 该属性值表示 是否构成了完整的单词
    private boolean isEnd;

    public Trie208() {
        nextNode = new Trie208[26];
        isEnd = false;
    }

    public void insert(String word) {
        // 这里必须要一个node 这样才可以让node一直向下走
        Trie208 node = this;
        // 插入操作
        for (int i = 0; i < word.length(); i++) {
            // 字符在哪个位置 就放在数组的对应位置
            int index = word.charAt(i) - 'a';
            if (node.nextNode[index] == null) {
                node.nextNode[index] = new Trie208();
            }
            if (i == word.length() - 1) {
                node.nextNode[index].isEnd = true;
                break;
            }

            node = node.nextNode[index];
        }

    }

    public boolean search(String word) {
        // 查找单词全
        Trie208 node = this;
        for (int i = 0; i < word.length(); i++) {
            // 字符在哪个位置 就放在数组的对应位置
            int index = word.charAt(i) - 'a';
            if (node.nextNode[index] == null) {
                return false;
            }
            if (i == word.length() - 1 && !node.nextNode[index].isEnd) {
                return false;
            }
            node = node.nextNode[index];
        }
        return true;

    }

    public boolean startsWith(String prefix) {
        // 查找单词前缀
        Trie208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            // 字符在哪个位置 就放在数组的对应位置
            int index = prefix.charAt(i) - 'a';
            if (node.nextNode[index] == null) {
                return false;
            }
            node = node.nextNode[index];
        }
        return true;
    }


}
