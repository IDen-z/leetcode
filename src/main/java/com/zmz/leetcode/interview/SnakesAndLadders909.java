package com.zmz.leetcode.interview;

import java.util.ArrayDeque;
import java.util.Queue;

public class SnakesAndLadders909 {
    // 给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）的每一行改变方向。
    //
    //你一开始位于棋盘上的方格  1。每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：
    //
    //选定目标方格 next ，目标方格的编号在范围 [curr + 1, min(curr + 6, n2)] 。
    //该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
    //传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
    //当玩家到达编号 n2 的方格时，游戏结束。
    //如果 board[r][c] != -1 ，位于 r 行 c 列的棋盘格中可能存在 “蛇” 或 “梯子”。那个蛇或梯子的目的地将会是 board[r][c]。编号为 1 和 n2 的方格不是任何蛇或梯子的起点。
    //
    //注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
    //
    //举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3 上的梯子前往方格 4 。（简单来说，类似飞行棋，玩家掷出骰子点数后移动对应格数，遇到单向的路径（即梯子或蛇）可以直接跳到路径的终点，但如果多个路径首尾相连，也不能连续跳多个路径）
    //返回达到编号为 n2 的方格所需的最少移动次数，如果不可能，则返回 -1。


    // TODO 这道题要用BFS解决
    // 这道题不太适合用深度优先搜索（DFS）来解决。原因是：
    //
    //最短路径问题：DFS 不擅长解决最短路径问题，因为 DFS 会优先探索一条路径直到无法继续，然后回溯并探索其他路径。而在最坏情况下，DFS 可能会走很长的路径才能发现一种解法，不能保证在找到解时已经走过最短路径。
    //
    //广度优先搜索（BFS）的优势：广度优先搜索（BFS）是这类问题的理想选择，因为 BFS 按层次搜索（逐步扩展每一层的节点），在找到目标时，保证了当前步数一定是最少的。也就是说，BFS 一旦找到编号为 n² 的格子，它必定是通过最少的移动次数到达的。
    //
    //DFS 的问题：
    //DFS 会优先沿着一条路径递归地进行下去，可能会走过很长的一条路径后才回溯，而并不关心当前路径是否已经远离目标。
    //即使 DFS 找到编号为 n² 的格子，它也不能保证这是最优解，可能需要遍历其他所有可能的路径才能确定最短路径。
    //DFS 可以应用的场景：
    //DFS 通常适合应用在 寻找所有路径 或者 找某一条符合特定要求的路径 的场景中，而非 最短路径。
    //
    //总之，虽然理论上你可以使用 DFS 来遍历所有可能的路径，但在这个问题中，DFS 的效率远远低于 BFS，特别是在涉及到最短路径的情况下。

    public static void main(String[] args) {
        snakesAndLadders(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}});
    }

    public static int snakesAndLadders(int[][] board) {

        // 每次飞行棋一样 单向行走 类似树型结构
        // 寻找最短路径 通过BFS 第一个到达终点的就是最短路径
        // 使用数组的第一个 和第二个下标 记录当前 i j 下标

        // 记录走的步数
        int res = 0;
        // 记录每个格子是否访问过
        boolean[][] visited = new boolean[board.length][board.length];
        visited[board.length - 1][0] = true;
        // BFS 记录队列
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{board.length - 1, 0});
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] ints = queue.poll();
                // 判断是否走到终点
                int num = getNum(ints[0], ints[1], board.length);
                if (num == board.length * board.length) {
                    return res;
                }

                for (int j = 1; j <= 6; j++) {
                    // nextNum
                    int nextNum = num + j;
                    // TODO 这里需要考虑
                    if (nextNum > board.length * board.length) break;
                    // 根据nextNum 获取坐标
                    int[] pos = getPos(nextNum, board.length);
                    if (board[pos[0]][pos[1]] != -1) {
                        // 说明有绳子或蛇
                        int jump = board[pos[0]][pos[1]];
                        pos = getPos(jump, board.length);
                    }

                    if (!visited[pos[0]][pos[1]]) {
                        visited[pos[0]][pos[1]] = true;
                        queue.offer(new int[]{pos[0], pos[1]});
                    }
                }
            }

            // bfs层遍历一层 表示走了一步
            res++;
        }

        return -1;
    }


    // 将二维坐标 (r, c) 转换为棋盘编号
    private static int getNum(int r, int c, int n) {
        if ((n - 1 - r) % 2 == 0) {
            return (n - 1 - r) * n + (c + 1);
        } else {
            return (n - 1 - r) * n + (n - c);
        }
    }

    // 将棋盘编号转换为二维坐标 (r, c)
    private static int[] getPos(int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;
        if (r % 2 == 0) {
            return new int[]{n - 1 - r, c};
        } else {
            return new int[]{n - 1 - r, n - 1 - c};
        }
    }


}
