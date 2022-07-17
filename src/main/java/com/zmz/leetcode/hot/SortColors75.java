package com.zmz.leetcode.hot;

/**
 * 颜色分类
 */
public class SortColors75 {

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 必须在不使用库的sort函数的情况下解决这个问题。
     */
    public void sortColors(int[] nums) {
        // 这道题其实只要交换0 2的位置 0 1的位置即可
        // 可以遍历两次 第一次交换 01 第二次交换02
        // 利用双指针 可以将过程缩短

        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1 ) {
                int temp = nums[i];
                nums[i] = nums[index1];
                nums[index1] = temp;
                index1++;
            } else if (nums[i] == 0 ) {
                int temp = nums[i];
                nums[i] = nums[index2];
                nums[index2] = temp;
                if (index2<index1){
                    temp = nums[i];
                    nums[i] = nums[index1];
                    nums[index1] = temp;
                }
                index1++;
                index2++;
            }
            i++;
        }
    }


}
