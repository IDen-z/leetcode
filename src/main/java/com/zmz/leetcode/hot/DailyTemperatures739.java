package com.zmz.leetcode.hot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度739
 */
public class DailyTemperatures739 {

    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
     * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // 暴力解法 直接找每个元素后面第一个比自己大的下标 计算差值
        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int current = temperatures[i];
            if (current < 100) {
                for (int j = i + 1; j < length; j++) {
                    if (temperatures[j] > current) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public int[] dailyTemperaturesOff(int[] temperatures) {
        /*
        Next Greater问题:下一个大于xx的元素->单调递增栈;下一个小于xx的元素->单调递减栈
        递增与递减均是从栈顶->栈底
        主要思路:维护一个从栈顶->栈底递增(非严格)的单调栈,栈中存储元素索引即可->遍历数组每个元素
            1.当栈为空直接入栈
            2.当temperatures[i]<=栈顶元素对应索引->说明还没找到栈顶对应元素下一个更大元素->直接入栈
            3.当temperatures[i]>栈顶元素对应索引->说明找到栈顶对应元素下一个更大元素->弹出栈顶并在相应位置记录结果
         */
        int len = temperatures.length;
        int[] res = new int[len]; // 初始化为0
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            // 栈非空并且当前元素>栈顶索引对应元素,说明找到栈顶元素对应下一个更大的元素->当前元素
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) {
                // 记住res的是记录距离几天
                int pop = stack.pollFirst();
                res[pop] = i - pop;
            }
            // 其余情况均入栈
            stack.addFirst(i);
        }
        return res;
    }


}
