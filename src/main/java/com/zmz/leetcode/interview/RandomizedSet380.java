package com.zmz.leetcode.interview;

import java.util.*;

public class RandomizedSet380 {
    // 实现RandomizedSet 类：
    //
    //RandomizedSet() 初始化 RandomizedSet 对象
    //bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
    //bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
    //int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
    //你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public RandomizedSet380() {
        // 需要将变长数组和哈希表结合，变长数组中存储元素，
        // 哈希表中存储每个元素在变长数组中的下标。
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();

    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int size = nums.size();
        nums.add(val);
        indices.put(val,size);
        return true;
    }


    public boolean remove(int val) {
        if (!indices.containsKey(val)){
            return false;
        }
        // 获取要移除的元素所在的下标
        int index = indices.get(val);
        // 把原有最后一个位置的元素 放在要移除元素的位置上，保证可变数组的连续性
        Integer lastVal = nums.get(nums.size() - 1);
        nums.set(index,lastVal);
        nums.remove(nums.size()-1);
        indices.put(lastVal,index);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }


}


