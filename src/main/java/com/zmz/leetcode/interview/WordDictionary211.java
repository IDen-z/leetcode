package com.zmz.leetcode.interview;

public class WordDictionary211 {

    // 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
    //
    //实现词典类 WordDictionary ：
    //
    //WordDictionary() 初始化词典对象
    //void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
    //bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
    //
    //
    //示例：
    //
    //输入：
    //["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
    //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
    //输出：
    //[null,null,null,null,false,true,true,true]
    //
    //解释：
    //WordDictionary wordDictionary = new WordDictionary();
    //wordDictionary.addWord("bad");
    //wordDictionary.addWord("dad");
    //wordDictionary.addWord("mad");
    //wordDictionary.search("pad"); // 返回 False
    //wordDictionary.search("bad"); // 返回 True
    //wordDictionary.search(".ad"); // 返回 True
    //wordDictionary.search("b.."); // 返回 True

    // 纯字典树题目的变种题
    // 支持一个 . 作为通配符 进行匹配

    public static void main(String[] args) {
        WordDictionary211 wordDictionary = new WordDictionary211();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
//        wordDictionary.search("pad"); // 返回 False
//        wordDictionary.search(".pd"); // 返回 False
        wordDictionary.search("bad"); // 返回 True
//        wordDictionary.search(".ad"); // 返回 True
//        wordDictionary.search("b.."); // 返回 True
//        wordDictionary.search("..."); // 返回 True


    }

    boolean isEnd;
    private WordDictionary211[] nextNode;

    public WordDictionary211() {
        isEnd = false;
        // 哪个字符存在 就放在哪个位置上
        nextNode = new WordDictionary211[26];
    }

    public void addWord(String word) {
        WordDictionary211 node = this;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i] - 'a';
            if (node.nextNode[index] == null) {
                node.nextNode[index] = new WordDictionary211();
            }
            if (i == charArray.length - 1) {
                node.nextNode[index].isEnd = true;
//                break;
            }
            node = node.nextNode[index];
        }
    }


    // 因为有. 的存在 如果当前字符是 . 那么要把所有的nextNode都进行遍历 所以需要递归实现
    public boolean search(String word) {
//        return searchDfs(word, this);
        return dfsSearch(word, this);

    }

    private boolean searchDfs(String word, WordDictionary211 node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // 遇到 '.', 尝试匹配所有子节点
                for (WordDictionary211 nextNode : node.nextNode) {
                    if (nextNode != null && searchDfs(word.substring(i + 1), nextNode)) {
                        return true;
                    }
                }
                // TODO 这个return false很重要 当某个位置遇到.符号时 需要把该位置其他的字符都作为潜在nextNode进行遍历（递归）
                // 当都不返回true时 说明此时这个. 符合未匹配 返回false
                return false; // 如果没有匹配，返回 false
            } else {
                int index = c - 'a';
                if (node.nextNode[index] == null) {
                    return false; // 找不到字符，返回 false
                }
                node = node.nextNode[index];
            }
        }
        return node.isEnd; // 检查是否是单词的结束
    }


    private boolean dfsSearch(String word, WordDictionary211 node) {
        // 递归辅助函数
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // 字符.为通配符
                // 递归寻找所有
                for (WordDictionary211 curNode : node.nextNode) {
                    if (curNode != null && dfsSearch(word.substring(i + 1), curNode)) {
                        // TODO 你在找到一个子节点后，立即返回了 dfsSearch 的结果。如果这个子节点没有匹配成功，整个方法就会返回 false，而你可能还有其他子节点可以匹配。
                        //你应该继续检查所有可能的子节点，直到找到一个成功的匹配，或者检查完所有子节点后返回 false。
                        return true;
                    }
                }
                // TODO
                return false;
            } else {
                int index = c - 'a';
                if (node.nextNode[index] == null) {
                    return false; // 找不到字符，返回 false
                }
                node = node.nextNode[index];
            }
        }
        return node.isEnd;


    }


}
