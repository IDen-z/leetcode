package com.zmz.leetcode.hot;

/**
 * 把二叉搜索树转换为累加树
 */
public class ConvertBST538 {

    /**
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
     * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     * <p>
     * 提醒一下，二叉搜索树满足下列约束条件：
     * <p>
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     */
    public TreeNode convertBST(TreeNode root) {
        // 逆序中序遍历
        // 右节点 中节点 左节点
        dfsHelper(root);
        return root;
    }

    int sum = 0;

    private void dfsHelper(TreeNode node) {
        // 递归终止条件
        if (node == null) {
            return;
        }
        if (node.right != null) {
            dfsHelper(node.right);
        }
        sum += node.val;
        node.val = sum;
        if (node.left != null) {
            dfsHelper(node.left);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.createTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        ConvertBST538 convertBST538 =new ConvertBST538();
        convertBST538.convertBST(tree);


    }

}
