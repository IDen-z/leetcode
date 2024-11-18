package com.zmz.leetcode.interview;

import java.util.*;

public class ZigzagLevelOrder103 {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
     * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * <p>
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[20,9],[15,7]]
     */


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 锯齿状的层序遍历
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        // false 正向遍历 true 反向
        boolean flag = false;
        while (!deque.isEmpty()) {
            // 队列不为空时进行遍历
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            // 锯齿装 给一个flag 控制左右
            if (!flag) {
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    list.add(poll.val);
                    if (poll.left != null) {
                        deque.offer(poll.left);
                    }
                    if (poll.right != null) {
                        deque.offer(poll.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.pollLast();
                    list.add(poll.val);
                    if (poll.right != null) {
                        deque.offerFirst(poll.right);
                    }
                    if (poll.left != null) {
                        deque.offerFirst(poll.left);
                    }
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
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
