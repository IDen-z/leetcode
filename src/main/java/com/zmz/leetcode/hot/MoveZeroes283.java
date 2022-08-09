package com.zmz.leetcode.hot;

/**
 * 移动零
 */
public class MoveZeroes283 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     */
    public void moveZeroes(int[] nums) {
        // 利用双指针
        // 左指针指向的0
        // 右指针指向的是非零数
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

    }

    public void moveZeroesOff(int[] nums) {
        // 利用冒泡的思想
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;

            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;

        }
    }

    public static void main(String[] args) {
        MoveZeroes283 moveZeroes283 = new MoveZeroes283();
        int[] nums = new int[]{1, 2, 3, 0, 1};
        moveZeroes283.moveZeroes(nums);

    }

}
