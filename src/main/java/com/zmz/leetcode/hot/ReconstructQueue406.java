package com.zmz.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 根据身高重建队列
 */
public class ReconstructQueue406 {

    /**
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     * <p>
     * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
     */
    public int[][] reconstructQueue(int[][] people) {
        // 先排序再插入
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] - o2[0] < 0) {
                return 1;
            } else if (o1[0] - o2[0] == 0) {
                return o1[1] - o2[1];
            } else {
                return -1;
            }
        });
//        int[][] res = new int[people.length][people[0].length];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] >= list.size()) {
//                res[i] = people[i];  错误写法
                list.add(people[i]);
            } else {
                // 这里不能用数组直接替代 应该是插入操作
//                res[people[i][1]] = people[i];  错误写法
                list.add(people[i][1], people[i]);
            }
        }
        return list.toArray(new int[people.length][people[0].length]);
    }

    public static void main(String[] args) {
        ReconstructQueue406 reconstructQueue406 = new ReconstructQueue406();
        int[][] people = new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        reconstructQueue406.reconstructQueue(people);

    }


}
