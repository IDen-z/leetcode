package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * 对称二叉树
 */
public class IsSymmetric101 {

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     */
    public boolean isSymmetricMy(TreeNode root) {
        // 第一思路是
        // 对称二叉树中序遍历后是一个对称数组 可以先进行一边中序遍历
        // 然后判断list是否是对称
        // 这种思路不对 1，2，2，2，null，2，
        // 当这种用例时中序遍历是对称的 但是不通过
        if (root == null) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        order(root, list);
        // 判断list是否对称
        return checkList(list);
    }

    private boolean checkList(ArrayList<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (list.get(l++) != list.get(r--)) {
                return false;
            }
        }
        return true;
    }

    public void order(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            order(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            order(node.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(new Integer[]{1, 2, 2, 2, null, 2});
        IsSymmetric101 isSymmetric101 = new IsSymmetric101();
        isSymmetric101.isSymmetricMy(root);
    }

    /**
     * 正确答案
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfsCheck(root.left, root.right);
    }

    public boolean dfsCheck(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return dfsCheck(l.left, r.right) && dfsCheck(l.right, r.left);
    }

}
