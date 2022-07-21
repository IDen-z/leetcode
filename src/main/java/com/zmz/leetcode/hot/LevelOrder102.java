package com.zmz.leetcode.hot;

import java.util.*;

/**
 * 二叉树的层序遍历
 */
public class LevelOrder102 {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 利用bfs进行求解
        if (root == null) {
            return res;
        }
        // 利用一个队列来辅助操作  双向队列 一边出 一边入
        Deque<TreeNode> deque = new ArrayDeque<>();
        bfsMethod(root, deque);
        return res;
    }

    //    int count = 0;
    List<List<Integer>> res = new ArrayList<>();

    public void bfsMethod(TreeNode node, Deque<TreeNode> deque) {
        if (deque.isEmpty()) {
            deque.add(node);
        }
        while (!deque.isEmpty()) {
            int count = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode treeNode = deque.pollFirst();
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
                list.add(treeNode.val);
            }
            res.add(list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        LevelOrder102 levelOrder102 = new LevelOrder102();
        levelOrder102.levelOrder(root);
    }


}
