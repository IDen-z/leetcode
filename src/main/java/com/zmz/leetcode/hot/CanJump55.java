package com.zmz.leetcode.hot;

/**
 * 跳跃游戏
 */
public class CanJump55 {

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标。
     */
    public boolean canJump(int[] nums) {
        // 感觉需要采用回溯算法
        // 结果超出时间复杂度
        return dfsJump(0, nums);
    }

    public boolean dfsJump(int index, int[] nums) {
        if (index > nums.length - 1) {
            return false;
        }
        if (index == nums.length - 1) {
            // 表示跳到了最后一位
            return true;
        }
        for (int i = 1; i <= nums[index]; i++) {
//             尝试跳跃
            boolean b = dfsJump(index + i, nums);
            if (b) {
                return b;
            }
        }
        return false;
    }

    public boolean canJumpOff(int[] nums) {
        // 贪心算法
        // 遍历一边数组
        // 计算每个位置可跳的最大值
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(i + nums[i], max);
        }
        return true;
    }

    public static void main(String[] args) {
        CanJump55 canJump55 = new CanJump55();
        boolean b = canJump55.canJumpOff(new int[]{3, 2, 1, 0, 4});
        System.err.println(b);
    }

}
