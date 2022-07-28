package com.zmz.leetcode.hot;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 */
public class LRUCache146 {

    /**
     * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     */
    private Deque<Integer> deque;
    private Map<Integer, Integer> map;
    private int capacity;

    /**
     * 有参构造器
     */
    public LRUCache146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.deque = new ArrayDeque<>(capacity);
    }

    public int get(int key) {
        // 不包含返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        // 包含则转移至队列最前 最近使用 要在队列中
        deque.remove(key);
        deque.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {

        if (!deque.contains(key)) {
            // 如果map中已经存在
            if (deque.size() < capacity) {
                // 如果小于队列长度
                deque.addFirst(key);
                map.put(key, value);
            } else {
                map.remove(deque.removeLast());
                deque.addFirst(key);
                map.put(key, value);
            }
        } else {
            // 如果map中不存在
            deque.remove(key);
            map.remove(key);
            deque.addFirst(key);
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache146 lRUCache = new LRUCache146(10);
        lRUCache.put(10, 13); // 缓存是 {1=1}
        lRUCache.put(3, 17); // 缓存是 {1=1, 2=2}
        lRUCache.put(6, 11);
        lRUCache.put(10, 5);
        lRUCache.put(9, 10);
        lRUCache.get(13);
    }

}
