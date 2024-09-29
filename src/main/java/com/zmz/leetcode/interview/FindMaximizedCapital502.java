package com.zmz.leetcode.interview;

import java.util.*;

public class FindMaximizedCapital502 {

    // 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
    //
    //给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
    //
    //最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
    //
    //总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
    //
    //答案保证在 32 位有符号整数范围内。
    //
    //
    //
    //示例 1：
    //
    //输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
    //输出：4
    //解释：
    //由于你的初始资本为 0，你仅可以从 0 号项目开始。
    //在完成后，你将获得 1 的利润，你的总资本将变为 1。
    //此时你可以选择开始 1 号或 2 号项目。
    //由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
    //因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
    //示例 2：
    //
    //输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
    //输出：6

    public static void main(String[] args) {
        FindMaximizedCapital502 bean = new FindMaximizedCapital502();
        int maximizedCapitalOpt = bean.findMaximizedCapitalOpt(2, 0, new int[]{3, 2, 1}, new int[]{1, 1, 0});
        int maximizedCapitalOpt2 = bean.findMaximizedCapital(2, 0, new int[]{3, 2, 1}, new int[]{1, 1, 0});
        System.err.println();

    }


    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // 使用最大堆 保证每次选择的资本项目都可以获得最大收益

        // 针对项目资本进行排序 需要注意的是，排序后需要把对应项目的收益获取到，可以考虑map结构
//        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
        // TODO 这里不能用map 因为使用map不允许存在相同的key,相同成本的收益会被后来的覆盖 导致出错
        Map<Integer, Integer> map = new HashMap<>();
        // key表示启动项目需要的资本 value表示项目收益
        // 先初始化 然后根据value进行排序
        for (int i = 0; i < capital.length; i++) {
            map.put(capital[i], profits[i]);
        }
        // 本题关键在于 堆的维护和弹出 其实就是有条件维护 同时弹出K次就是最后的收益
        // 需要最大收益永远在堆顶
        Queue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < k; i++) {
            // k表示需要选择几次项目

            // 开始堆的维护 遍历treemap
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getKey() <= w) {
                    priorityQueue.offer(entry.getValue());
                    iterator.remove(); // 移除已加入的项目
                }
            }
            if (priorityQueue.isEmpty()) {
                break;
            }
            Integer poll = priorityQueue.poll();
            w += poll;
        }

        return w;
    }


    public int findMaximizedCapitalOpt(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }
        // 按资本排序
        projects.sort(Comparator.comparingInt(o -> o[0]));

        // 最大堆来选择利润最高的项目
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;

        for (int i = 0; i < k; i++) {
            // 将可启动的项目放入最大堆
            // idx保证了已经加入堆得项目 不会重复入堆
            while (idx < n && projects.get(idx)[0] <= w) {
                maxHeap.offer(projects.get(idx)[1]);
                idx++;
            }

            // 如果堆为空，说明没有可选项目
            if (maxHeap.isEmpty()) {
                break;
            }

            // 选择最高利润的项目
            w += maxHeap.poll();
        }

        return w;
    }


}
