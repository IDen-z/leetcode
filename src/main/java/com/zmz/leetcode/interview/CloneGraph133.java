package com.zmz.leetcode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {

    // 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
    //
    //图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
    //
    //class Node {
    //    public int val;
    //    public List<Node> neighbors;
    //}
    //
    //
    //测试用例格式：
    //
    //简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
    //
    //邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
    //
    //给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。


    public Node cloneGraph(Node node) {
// 这道题就是图的遍历 遍历过程中深度拷贝
        Map<Node, Node> map = new HashMap<Node, Node>();
        return dfsMethod(node, map);
    }

    private Node dfsMethod(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)){
            return map.get(node);
        }
        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList());
        // 哈希表存储
        map.put(node, cloneNode);

        for (Node next:node.neighbors){
            cloneNode.neighbors.add(dfsMethod(next,map));
        }
        return cloneNode;


    }


}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
