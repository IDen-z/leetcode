package com.zmz.leetcode.hot;

/**
 * 寻找重复数
 */
public class FindDuplicate287 {


    /**
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * <p>
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     * <p>
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     */
    public int findDuplicate(int[] nums) {
        // 暴力算法一定是超时的
        // 不用额外的空间
        // 由于是n+1的整数数组 那么一定有一个下标+1 的位置放的不是自己
        // 比如1放在0  2 放在1  3放在2
        // 思路就是交换对应顺序  知道发现已经放置了正确的值
        for (int i = 0; i < nums.length; i++) {
            // 外面这个for循环有点难以理解
            // 不能任意给个起点  因为有可能某个位置正好是对的
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                }
                // 不等于说明nums[i]的位置不对
//                int temp = nums[i];
//                nums[i] = nums[nums[i] - 1];
//                nums[nums[i] - 1] = temp;
                // 这里的交换必须先这样记录  因为先交换nums[i] 就不对了
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        FindDuplicate287 findDuplicate287 = new FindDuplicate287();
        int[] nums = new int[]{1, 2, 3, 4, 2};
        int duplicate = findDuplicate287.findDuplicate(nums);
        System.err.println(duplicate);

    }

}
