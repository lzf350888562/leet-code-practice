package source.leetcode.type;

/**
 * 买卖股票的最佳时机
 * 买卖股票 6题
 * 以第四题为基准
 * 第⼀题是只进⾏⼀次交易，相当于 k = 1；
 * 第⼆题是不限交易次数，相当于k = +infinity（正⽆穷）；
 * 第三题是只进⾏ 2 次交易，相当于 k = 2；
 * 剩下两道也是不限次数，但是加了交易「冷冻期」和「⼿续费」的额外条件，其实就是第⼆题的变种，都很容易处理。
 * <p>
 * 状态机:
 * dp[i][k][0 or 1]
 * 0 <= i <= n-1, 1 <= k <= K
 * n 为天数，⼤ K 为最多交易数
 * 此问题共 n × K × 2 种状态，全部穷举就能搞定。
 * 要求的最终答案是 dp[n - 1][K][0]
 * <p>
 * 状态转移:
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]) 今天没持股 = 昨天没持股+今天无操作 或者 昨天持股+今天售出 (取最大)
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]) 今天持股 = 昨天持股+今天无操作 或者 昨天没持股+今天买入 (取最大)
 * <p>
 * 基础状态
 * dp[-1][k][0] = 0
 * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0
 * dp[-1][k][1] = -infinity
 * 解释：还没开始的时候，是不可能持有股票的，⽤负⽆穷表⽰这种不可能。
 * dp[i][0][0] = 0
 * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0
 * dp[i][0][1] = -infinity
 * 解释：不允许交易的情况下，是不可能持有股票的，⽤负⽆穷表⽰这种不可能。
 */
public class MaxProfit {
    /**
     * 121
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        //  k 都是 1，不会改变，即 k 对状态转移已经没有影响了, 可以去掉
        //  新状态只和相邻的⼀个状态有关，其实不⽤整个 dp 数组，只需要⼀个变量储存相邻的那个状态就⾜够了，
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;                             // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);                      // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);                              // dp[i][1] = max(dp[i-1][1], -prices[i])
        }
        return dp_i_0;
    }

    /**
     * 122 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        //如果 k 为正⽆穷，那么就可以认为 k 和 k - 1 是⼀样的. 即状态转移与k没关系
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);      //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);        //dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])

        }
        return dp_i_0;
    }

    /**
     * 309. 最佳买卖股票时机含冷冻期
     * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     */
    int maxProfit_with_cool(int[] prices) {
        // 在122上进行改进
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);                  //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            //第 i 天选择 buy 的时候，要从 i-2 的状态转移，⽽不是 i-1 。
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);                //dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

    /**
     * 714. 买卖股票的最佳时机含手续费
     * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     */
    int maxProfit_with_fee(int[] prices, int fee) {
        // 在122上进行改进
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            //  相当于买⼊股票的价格升⾼了, 在两处减手续费都可以
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);          // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);      // dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
        }
        return dp_i_0;
    }

    /**
     * 123  给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * k = 2 和前⾯题⽬的情况稍微不同，因为上⾯的情况都和 k 的关系不太⼤。
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);      //dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
            dp_i21 = Math.max(dp_i21, dp_i10 - price);      //dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
            dp_i10 = Math.max(dp_i10, dp_i11 + price);      //dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
            dp_i11 = Math.max(dp_i11, -price);              //dp[i][1][0] = max(dp[i-1][1][0], 0 - prices[i])
        }
        return dp_i20;
    }

    /**
     * 188 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * k传入太大会OOM
     * 因为⼀次交易由买⼊和卖出构成，⾄少需要两天。所以说有效的限制 k 应该不超过 n/2;
     * 如果超过，就没有约束作⽤了，相当于 k = +infinity。
     */
    public int maxProfit4(int k, int[] prices) {
        int n = prices.length;
        if(k > (n+1)/2){        //买卖股票一个来回需要2天  n+1为了防止数组长度为奇数
            return 0;
        }
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++)
            for (int k_tmp = k; k_tmp >= 1; k_tmp--) {
                if (i - 1 == -1 && k_tmp - 1 == -1) {
                    dp[i][k_tmp][0] = Math.max(0,  Integer.MIN_VALUE + prices[i]);
                    dp[i][k_tmp][1] = Math.max(Integer.MIN_VALUE, 0 - prices[i]);
                } else if (i - 1 == -1 && k_tmp - 1 != -1){
                    dp[i][k_tmp][0] = Math.max(0,  Integer.MIN_VALUE + prices[i]);
                    dp[i][k_tmp][1] = Math.max(Integer.MIN_VALUE, 0 - prices[i]);
                } else if(i - 1 != -1 && k_tmp - 1 == -1){
                    dp[i][k_tmp][0] = Math.max(dp[i - 1][k_tmp][0], dp[i - 1][k_tmp][1] + prices[i]);
                    dp[i][k_tmp][1] = Math.max(dp[i - 1][k_tmp][1], 0 - prices[i]);
                }else{
                    dp[i][k_tmp][0] = Math.max(dp[i - 1][k_tmp][0], dp[i - 1][k_tmp][1] + prices[i]);
                    dp[i][k_tmp][1] = Math.max(dp[i - 1][k_tmp][1], dp[i - 1][k_tmp - 1][0] - prices[i]);
                }
            }
        return dp[n - 1][k][0];
    }


    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
