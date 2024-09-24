package com.zmz.leetcode.interview;

import java.util.*;

public class MinMutation433 {

    // 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
    //
    //假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
    //
    //例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
    //另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
    //
    //给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
    //
    //注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。


    public int minMutation(String startGene, String endGene, String[] bank) {
        // 最小 一般都是Bfs
        // 这道题其实建模起来就是一个拓扑图
        // 多向图
        // 当这个序列和bank中的节点中有一个字符区别时，表示这两个图的节点间存在边

        // 把bank放到集合中方便处理
        List<String> list = new ArrayList<>(Arrays.asList(bank));
        // TODO  已经变换过的基因序列可以记录下来  也可以把bank中的序列移除
        Set<String> hashSet = new HashSet<>();
        if (!list.contains(endGene)) {
            return -1;
        }
        char[] genes = {'A', 'C', 'G', 'T'};  // 可能的基因变化字符
        Queue<String> queue = new ArrayDeque<>();  // 用于BFS的队列
        queue.add(startGene);  // 从起始基因开始
        int steps = 0;

        while (!queue.isEmpty()) {
            // bfs使用队列
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endGene)) {
                    // BFS 找到了最终基因 此时就是最短路径
                    return steps;
                }

                // 否则沿着图边继续遍历
                // 这道题关键就在于没有明确出 边的连接 需要自己判断边
                // 只有当前基因通过 一步 的变化 且该变化后的基因存在与bank中
                // 说明此时图的边是建立起来的 把当前基因可达的下一个基因全部存到队列中来

                char[] charArray = poll.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char originChar = charArray[j];
                    for (char changeChar : genes) {
                        if (charArray[j] == changeChar) {
                            continue;
                        }
                        // 否则进行一步变化
                        charArray[j] = changeChar;
                        String newStr = new String(charArray);

                        // 判断变化后的str是否在bank中存在
                        if (list.contains(newStr) && !hashSet.contains(newStr)) {
                            queue.add(newStr);
                            hashSet.add(newStr);
                            // TODO 这里也有一步关键操作 如果不另外使用hashSet记录重复 就需要这个remove这步
//                            list.remove(newStr);
                        }
                        charArray[j] = originChar;
                        // 否则是无效变化 则继续进行循环
                    }
                }

            }
            steps++;
        }
        return -1;

    }

}
