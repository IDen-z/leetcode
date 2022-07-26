package com.zmz.leetcode.hot;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树展开为链表
 */
public class Flatten114 {

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * <p>
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 不考虑原地修改
        // 直接前序遍历  但是不知道为什么不过check
        // 二叉树的递归处理较为薄弱 应该常练常新

        TreeNode res = new TreeNode(root.val);
        TreeNode p = res;
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++) {
            res.right = list.get(i);
            res.left = null;
            res = res.right;
        }
        root = p;
    }

    public void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        if (node.left != null) {
            dfs(node.left, list);
        }
        if (node.right != null) {
            dfs(node.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        Flatten114 flatten114 = new Flatten114();
        flatten114.flatten(root);
        TreeNode tree = TreeUtil.createTree(new Integer[]{1, 2, 5, null, 3, null, 6, null, 4, null, null, null, 5, null, 6});
    }

    public void flattenOff(TreeNode root) {
        // 不递归 两层循环
        while (root != null) {
            // 大循环遍历每个节点
            if (root.left == null) {
                // 找到每个节点的左子树 进行迁移转换
                root = root.right;
            } else {
                TreeNode node = root.left;
                // 找到最右下的节点 为了等下将其拼接到root节点的右下方
                while (node.right != null) {
                    node = node.right;
                }
                // 开始进行树的拼接
                // 将root节点原右子树插入在 node节点的右侧
                node.right = root.right;
                // 再将拼接好的子树插入会root.right
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }

    }


}
