package com.zmz.leetcode.interview;

public class IsSameTree {

    // 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
    //
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：p = [1,2,3], q = [1,2,3]
    //输出：true
    //示例 2：
    //
    //
    //输入：p = [1,2], q = [1,null,2]
    //输出：false
    //示例 3：
    //
    //
    //输入：p = [1,2,1], q = [1,1,2]
    //输出：false
    boolean flag = true;


    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 针对树进行遍历 若节点不一致则返回false
//        if (p == null && q != null) {
//            return false;
//        }
//        if (q == null && p != null) {
//            return false;
//        }

        preDfs(p, q);
        return flag;
    }

    private void preDfs(TreeNode p, TreeNode q) {
        if (!flag) {
            return;
        }
        if (p == null && q == null) {
            return;
        } else if (p == null || q == null) {
            flag = false;
            return;
        }
        if (p.val != q.val) {
            flag = false;
            return;
        }
        preDfs(p.left, q.left);
        preDfs(p.right, q.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
