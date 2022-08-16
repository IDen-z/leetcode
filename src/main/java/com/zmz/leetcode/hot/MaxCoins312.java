package com.zmz.leetcode.hot;

/**
 * 戳气球
 */
public class MaxCoins312 {

    /**
     * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     * <p>
     * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
     * <p>
     * 求所能获得硬币的最大数量。
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 创建一个辅助数组，并在首尾各添加1，方便处理边界情况
        int[] temp = new int[n + 2];
        temp[0] = 1;
        temp[n + 1] = 1;
        // 初始化temp数组
        for (int i = 0; i < n; i++) {
            temp[i + 1] = nums[i];
        }
        // 动态规划数组 dp[i][j] 表示开区间(i,j)内 戳破气球所获得的最大金币
        // 1,1,3,5,8,1
        // 0,1,2,3,4,5
        int[][] dp = new int[temp.length][temp.length];
        // 由于是开区间 因此每次i j 的间隔都应该最小是3
        // 这里必须要倒着遍历 是为什么？
        // 正向也是可以的，核心是 外面两层 for 循环之间要从小区间向大区间转移，也就是 j 和 i 的区间范围从小到大去转移
        for (int i = temp.length - 3; i >= 0; i--) {
            // 右区间
            for (int j = i + 2; j < temp.length; j++) {
                // 对k进行遍历取最大值
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + temp[i] * temp[j] * temp[k]);
                }
            }
        }
        return dp[0][dp.length - 1];
    }

    public static void main(String[] args) {
        MaxCoins312 maxCoins312 = new MaxCoins312();
        int[] nums = new int[]{3, 1, 5, 8};
        int i = maxCoins312.maxCoins(nums);
        System.err.println(i);

    }


}
