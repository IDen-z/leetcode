package com.zmz.leetcode.hot;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 */
public class IsValidBST98 {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 有效 二叉搜索树定义如下：
     * <p>
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    public boolean isValidBST(TreeNode root) {
        // 收藏再做
        // 二叉搜索树的中序遍历是单调递增的
        // 这句话是重点
        // 那么维护一个子序列 只要判断子序列的最后一个值是否是比当前遍历的值小即可
        if (root == null) {
            return false;
        }
        return dfsIntervalOrder(root, new ArrayList<>(), 0);
    }

    /**
     * 中序遍历
     */
    public boolean dfsIntervalOrder(TreeNode node, List<Integer> res, int flag) {
        if (flag == 1) {
            return false;
        }
        if (node.left != null) {
            if (!dfsIntervalOrder(node.left, res, flag)) {
                flag = 1;
                return false;
            }
        }
        if (!res.isEmpty() && res.get(res.size() - 1) >= node.val) {
            flag = 1;
            return false;
        } else {
            res.add(node.val);
        }
        if (node.right != null) {
            return dfsIntervalOrder(node.right, res, flag);
        }
        return flag != 1;
    }

    public static void main(String[] args) {
        Integer[] treeArr = new Integer[]{5, 1, 4, null, null, 3, 6};
        TreeNode root = TreeUtil.createTree(treeArr);
        IsValidBST98 isValidBST98 = new IsValidBST98();
        boolean validBST = isValidBST98.isValidBSTOff(root);
        System.err.println(validBST);
    }

    public boolean isValidBSTOff(TreeNode root) {
        return inorderOff(root);
    }

    long pre = Long.MIN_VALUE; // 记录上一个节点的值，初始值为Long的最小值

    // 中序遍历
    private boolean inorderOff(TreeNode node) {
        if (node == null) return true;
        boolean l = inorderOff(node.left);
        if (node.val <= pre) return false;
        pre = node.val;
        boolean r = inorderOff(node.right);
        return l && r;
    }

}
