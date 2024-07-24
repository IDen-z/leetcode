package com.zmz.leetcode.interview;

public class Merge88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针 遍历两次数组
        // 边界判断
        int index1 = 0;
        int index2 =0;
        int[] res = new int[m+n];
        int i = 0;
        while(index1 < m || index2 < n){
            if(index1>=m){
                res[i]=nums2[index2];
                index2++;
                i++;
                continue;
            }
            if(index2>=n){
                res[i]=nums1[index1];
                index1++;
                i++;
                continue;
            }

            if(nums1[index1]<=nums2[index2]){
                res[i]=nums1[index1];
                index1++;
            }else{
                res[i]=nums2[index2];
                index2++;
            }
            i++;
        }

        // copy res数组
        for(int j=0;j<m+n;j++){
            nums1[j] = res[j];
        }



    }


}