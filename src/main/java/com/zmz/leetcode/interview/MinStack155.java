package com.zmz.leetcode.interview;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack155 {
    // 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    //
    //实现 MinStack 类:
    //
    //MinStack() 初始化堆栈对象。
    //void push(int val) 将元素val推入堆栈。
    //void pop() 删除堆栈顶部的元素。
    //int top() 获取堆栈顶部的元素。
    //int getMin() 获取堆栈中的最小元素。
    //

    // TODO 辅助栈 用栈来存储最小值
    // 2 4 1 3   2 2 1 1
    Deque<Integer> deque;
    Deque<Integer> minDeque;

    public MinStack155() {
        deque = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
    }

    // 1 2 3 4　　   2 4 1 3
    public void push(int val) {
        deque.addLast(val);
        if (minDeque.isEmpty()) {
            minDeque.addLast(val);
        } else {
            minDeque.addLast(Math.min(val, minDeque.getLast()));
        }
    }

    public void pop() {
        deque.removeLast();
        minDeque.removeLast();
    }

    public int top() {
        return deque.getLast();
    }

    public int getMin() {
        return minDeque.getLast();
    }

}
