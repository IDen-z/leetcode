package com.zmz.leetcode.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Combine77 {


    // 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    //
    //你可以按 任何顺序 返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 4, k = 2
    //输出：
    //[
    //  [2,4],
    //  [3,4],
    //  [2,3],
    //  [1,2],
    //  [1,3],
    //  [1,4],
    //]
    //示例 2：
    //
    //输入：n = 1, k = 1
    //输出：[[1]]
    //

    public static void main(String[] args) {
        Combine77 combine77 = new Combine77();
        combine77.combineBFS(4, 2);
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // BFS
//        Queue<Integer> queue = new ArrayDeque<>();
//        List<List<Integer>> res = new ArrayList<>();
//
//        for (int i = 1; i <= n; i++) {
//            queue.add(i);
//            while (!queue.isEmpty()) {
//
//            }
//
//
//        }

        List<Integer> list = new ArrayList<>();
        dfsMethod(1, n, k, list);
        return res;
    }

    private void dfsMethod(int start, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            // TODO 不能remove 引用类型 会导致结果异常
            list.add(i); // 选择当前数字
            dfsMethod(i + 1, n, k, list); // 递归
            list.remove((Integer) i); // 撤销选择
        }

    }


    // 再写一边DFS
    public List<List<Integer>> combine2(int n, int k) {
        // 这种求所有组合的一般都是DFS
        List<List<Integer>> res = new ArrayList<>();
        // 引用类型可以不用类变量
        dfsHelper(res, 1, n, k, new ArrayList<Integer>());

        return res;

    }

    private void dfsHelper(List<List<Integer>> res, int i, int n, int k, ArrayList<Integer> list) {
        // i表示起始位置
        // 先写递归终止条件
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            dfsHelper(res, j + 1, n, k, list);
            list.remove(list.size() - 1);
        }

    }


    public List<List<Integer>> combineBFS(int n, int k) {
        // BFS
        // 把每一个可能的组合作为节点存入队列

        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();

        // 初始化队列
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            queue.add(list);
        }

        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            if (poll.size() == k) {
                res.add(new ArrayList<>(poll));
                continue;
            }
            // 下一数字起始值其实就是+1
            int start = poll.get(poll.size() - 1) + 1;

            for (int i = start; i <= n; i++) {
                ArrayList<Integer> newList = new ArrayList<>(poll);
                newList.add(i);
                queue.add(newList);
            }
        }
        return res;


    }


}
