package com.zmz.leetcode.hot;

import java.util.Stack;

/**
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestor236 {


    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 这道题笔试面试出现频率很高 需要反复练习

        // 其实这道题可以拆分为两个问题
        // 问题1 利用递归找到 从根节点 到达 p q 两个节点的下沉路径
        // 问题2 找到路径后 找到两段路径中 最后一个公共节点 利用栈
        stack1.push(root);
        stack2.push(root);
        dfsFind(stack1, root, p);
        dfsFind(stack2, root, q);
        return findCommonAncestor(stack1, stack2);
    }

    private TreeNode findCommonAncestor(Stack<TreeNode> stack1, Stack<TreeNode> stack2) {
        // 该方法用来计算两个栈的最早公共节点
        while (!stack1.empty() || !stack2.isEmpty()) {
            while (stack1.size() > stack2.size()) {
                // 栈1的大小 比2大
                stack1.pop();
            }
            while (stack2.size() > stack1.size()) {
                // 栈1的大小 比2大
                stack2.pop();
            }
            if (stack1.peek() == stack2.peek()) {
                return stack1.peek();
            }
            stack1.pop();
            stack2.pop();
        }
        return null;
    }

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    private boolean dfsFind(Stack<TreeNode> stack, TreeNode node, TreeNode target) {
        if (node.val == target.val) {
            // 找到了目标节点
            return true;
        }
        if (node.left != null) {
            stack.push(node.left);
            if (dfsFind(stack, node.left, target)) {
                return true;
            }
            stack.pop();
        }
        if (node.right != null) {
            stack.push(node.right);
            if (dfsFind(stack, node.right, target)) {
                return true;
            }
            stack.pop();
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        LowestCommonAncestor236 lowestCommonAncestor236 = new LowestCommonAncestor236();
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(7);
        lowestCommonAncestor236.lowestCommonAncestor(root, p, q);

    }

}
