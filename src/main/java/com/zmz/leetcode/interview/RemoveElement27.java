package com.zmz.leetcode.interview;

import java.util.ArrayList;

public class RemoveElement27 {
    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,2,3,0,4,2};
        removeElement2(a,2);
    }


    public static int removeElement(int[] nums, int val) {
        ArrayList<Integer> list = new ArrayList<>();
        int k =0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                list.add(nums[i]);
                k++;
            }
        }
        for (int j =0;j<list.size();j++){
            nums[j] = list.get(j);
        }
        return k;
    }
    // [0,1,2,2,3,0,4,2]

    // 快慢指针
    public static int removeElement2(int[] nums, int val) {
        int p1 =0;
        int p2 =0;
        while(p1< nums.length){
            if (nums[p1]!=val){
                nums[p2] = nums[p1];
                p2++;
            }
            p1++;
        }
        return p2;


    }

}
