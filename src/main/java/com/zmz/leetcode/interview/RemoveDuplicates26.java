package com.zmz.leetcode.interview;

public class RemoveDuplicates26 {

    public static void main(String[] args) {
        int[] a = new int[]{1,1,2};
        removeDuplicates(a);
    }

    // 输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
    public static int removeDuplicates(int[] nums) {
        // 快慢指针
//        if (nums.length <= 1) {
//            return nums.length;
//        }
        int p1 = 0;
        int p2 = 0;

        while (p2 < nums.length) {
            if (nums[p1]==nums[p2]){
                p2++;
            }else if (nums[p1]!=nums[p2]){
                nums[++p1] = nums[p2++];
            }
        }
        return p1+1;


    }


}
