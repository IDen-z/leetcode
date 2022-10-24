package com.zmz.leetcode.daily;

/**
 * 分割数组
 */
public class PartitionDisjoint915 {

    /**
     * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
     * <p>
     * left 中的每个元素都小于或等于 right 中的每个元素。
     * left 和 right 都是非空的。
     * left 的长度要尽可能小。
     * 在完成这样的分组后返回 left 的 长度 。
     * <p>
     * 用例可以保证存在这样的划分方法。
     */
    public int partitionDisjoint(int[] nums) {
        // 首先初始化一个最大值数组
        int len = nums.length;
        int[] minRight = new int[len];
        // left 中的最大值小于等于 right 中的最小值
        minRight[len - 1] = nums[len - 1];
        // 第一次遍历 初始化一个最右侧的最小数组
        for (int i = len - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }
        // 第二次遍历 左边的最大值小于right中的最小值 找到第一个
        int maxLeft = 0;
        for (int i = 0; i < len - 1; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);
            if (maxLeft <= minRight[i + 1]) {
                return i + 1;
            }
        }
        return len - 1;
    }

    public static void main(String[] args) {
        PartitionDisjoint915 partitionDisjoint915 = new PartitionDisjoint915();
        int[] n = new int[] {5,0,3,8,6};
        int i = partitionDisjoint915.partitionDisjoint(n);
        System.err.println(i);

    }


}
