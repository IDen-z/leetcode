package com.zmz.leetcode.hot;

import com.sun.org.apache.xpath.internal.FoundIndex;

/**
 * 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays4 {


    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 寻找两个正序数组的中位数
        // sortedArray + 寻找  想到了二分查找
        // 但是这是两个数组 暴力自然是数组合并后利用二分
        int m = nums1.length;
        int n = nums2.length;
        int temp[] = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int k = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                temp[k++] = nums1[index1++];
            } else {
                temp[k++] = nums2[index2++];
            }
        }
        while (index1 < m) {
            temp[k++] = nums1[index1++];
        }
        while (index2 < n) {
            temp[k++] = nums2[index2++];
        }
        // 接下来直接找中间数
        int x = (m + n) / 2;
        if (x == 0) {
            return temp[0];
        }
        if ((m + n) % 2 == 0) {
            return (double) (temp[x - 1] + temp[x]) / 2;
        } else {
            return temp[x];
        }
    }

    /**
     * 官方题解
     */
    public double findMedianSortedArraysOff(int[] nums1, int[] nums2) {
        // 官网题解
        // 如果对时间复杂度的要求有 log，通常都需要用到二分查找，这道题也可以通过二分查找实现。
        // 根据中位数的定义，当 m+n 是奇数时，中位数是两个有序数组中的第 (m+n)/2 个元素，
        // 当 m+n 是偶数时，中位数是两个有序数组中的第(m+n)/2 个元素和第 (m+n)/2+1 个元素的平均值。因此，这道题可以转化成寻找两个有序数组中的第 k 小的数，其中 kk 为 (m+n)/2或 (m+n)/2+1。

        return 0;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays4 findMedianSortedArrays4 = new FindMedianSortedArrays4();
        int[] n1 = new int[]{1, 3, 5};
        int[] n2 = new int[]{2, 7};
        double medianSortedArrays = findMedianSortedArrays4.findMedianSortedArrays(n1, n2);
        System.err.println(medianSortedArrays);


    }


}
