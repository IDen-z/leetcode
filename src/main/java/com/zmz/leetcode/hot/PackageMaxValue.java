package com.zmz.leetcode.hot;

public class PackageMaxValue {


    public static void main(String[] args) {

        int n = 5, w = 10;                    //物品个数，背包容量
        int[] value = {0, 6, 3, 5, 4, 6};     //各个物品的价值
        int[] weight = {0, 2, 2, 6, 5, 4};    //各个物品的重量
        System.out.println(getMaxValue(weight, value, w, n));
        System.out.println(packageMaxValue(weight, value, w, n));
    }

    /**
     * 01背包问题
     */
    public static int packageMaxValue(int[] weight, int[] value, int w, int n) {
        // weight 表示物品重量
        // value 表示物品价值
        // w 表示背包总大小
        // n 表示物品数量
        // 初始化dp数组
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                // 01背包问题 其实就是拿或者不拿的问题
                if (j < weight[i]) {
                    // 如果背包不够拿当前物品重量 那么就是上一个物品的最大价值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[n][w];
    }

    /**
     * official
     */
    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] table = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) { //物品
            for (int j = 1; j <= w; j++) {  //背包大小
                if (weight[i] > j) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    table[i][j] = table[i - 1][j];
                    // System.out.print(table[i][j]+ " ");
                } else { //装得下，Max{装物品i， 不装物品i}
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weight[i]] + value[i]);
                    //System.out.print(table[i][j]+ " ");
                }
            }
            // System.out.println();
        }
        return table[n][w];
    }

}
