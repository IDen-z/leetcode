package com.zmz.leetcode.hot;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 */
public class CodeC297 {

    /**
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     * <p>
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     */
    String res = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 这道题解题的关键在于前序遍历一定不能停在当前节点 要多遍历一层 把null的也记录下来
        dfsSearch(root);
        return res;
    }

    private void dfsSearch(TreeNode node) {
        if (node == null) {
            res += "null,";
            return;
        }
        res += node.val + ",";
        dfsSearch(node.left);
        dfsSearch(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        String[] split = data.split(",");
        for (String s : split) {
            deque.addLast(s);
        }
        // 在反序列化字符串时
        TreeNode root = dfsHelper(deque);
        return root;
    }

    private TreeNode dfsHelper(ArrayDeque<String> deque) {
        if (deque.isEmpty()) {
            return null;
        }
        String s = deque.removeFirst();
        if (s.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = dfsHelper(deque);
        node.right = dfsHelper(deque);
        return node;
    }


    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, null, null, 4, 5};
        TreeNode tree = TreeUtil.createTree(nums);
        CodeC297 codeC297 = new CodeC297();
        String serialize = codeC297.serialize(tree);
        System.err.println(serialize);
        TreeNode deserialize = codeC297.deserialize("1,2,null,null,3,4,null,null,5,null,null");
        System.err.println(deserialize);
    }


}
