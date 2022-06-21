package com.zmz.leetcode.tag.array1;

/**
 * 合并两个有序数组
 */
public class Merge66 {

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * <p>
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     */


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 第一反应是给两个指针 分别指向两个不同的数组
        int index1 = 0;
        int index2 = 0;
        int[] res = new int[m + n];
        int index = 0;
        while (index1 < m || index2 < n) {
            if (index1 == m) {
                res[index] = nums2[index2];
                index2++;
            } else if (index2 == n) {
                res[index] = nums1[index1];
                index1++;
            } else if (nums1[index1] <= nums2[index2]) {
                res[index] = nums1[index1];
                index1++;
            } else {
                res[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        for (int i = 0; i < res.length; i++) {
            nums1[i] = res[i];
        }
    }

    public static void main(String[] args) {
        Merge66 merge66 = new Merge66();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 4};
        merge66.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.err.println(i);
        }

    }


}
