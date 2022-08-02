package com.zmz.leetcode.hot;

import java.util.*;

/**
 * 课程表
 */
public class CanFinish207 {


    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     * <p>
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 这道题需要用到拓扑和BFS 需要收藏再做
        // 首先初始化图 graph
        // 该数组用来记录  每个节点的 入度值
        int[] indegrees = new int[numCourses];
        // 该list用来记录 每个节点的邻接节点 也就是图的拓扑关系
        List<List<Integer>> adjacency = new ArrayList<>();
        // 该队列用来记录当入度为0时 可以进行 课程的学习
        Queue<Integer> queue = new ArrayDeque<>();
        // 对上述数据结构 进行初始化
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // 对课程的二维数组进行遍历 将每个课程的入度 和 邻接点记录
        for (int[] cp : prerequisites) {
            // 这里题目中已经给出了一共有多少节课程 因此 计算几点入度的数组 正好可以每个课程作为数组下标
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // 至此graph的初始化已经完成
        for (int i = 0; i < numCourses; i++) {
            // 把所有的前置入度为0的加入队列
            // 也就是没有前置课程的课程加入队列
            if (indegrees[i] == 0) queue.add(i);
        }
        // 开始对队列进行处理 弹出 无入度的
        while (!queue.isEmpty()) {
            // 当队列不为空时
            // 每次弹出一个课程 同时将对应有该课程的入度表减一
            Integer remove = queue.poll();
            numCourses--;
            List<Integer> list = adjacency.get(remove);
            for (int i : list) {
                indegrees[i]--;
                if (indegrees[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return numCourses == 0;
    }

}
