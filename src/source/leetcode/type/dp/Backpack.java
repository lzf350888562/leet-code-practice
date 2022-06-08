package source.leetcode.type.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 背包问题
 */
public class Backpack {
    /**
     * 1.  0-1背包: 可装载重量W的背包 和 N个物品, 每个物品带有重量和价值两个属性, 第i个物品重量为 wt[i], 价值为val[i], 求这个背包能装的最大价值.
     * 状态: 背包的容量和可选择的物品  选择: 是否装进背包   值: 价值   求dp[i][w]  basecase=0=dp[0][x]=dp[x][0]
     */
    public int backpack01(int W, int N, int[] wt, int[] val) {
        // dp[i][w] 表示前i个物品且背包容量剩余w时的最大价值
        int[][] dp = new int[W + 1][N + 1];     //自动初始化basecase为0
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w < W; w++) {
                //物品数组从0开始 所以要减一
                if (w - wt[i - 1] < 0) {    //如果背包剩余容量小于当前物品容量, 表示不能装入
                    dp[i][w] = dp[i - 1][w]; //与上一个物品状态值相同
                } else {
                    //状态转换  前一个物品
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 2. 子集背包
     * 416. 分割等和子集
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 转换为背包问题: 给⼀个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为nums[i] 。如何将背包装满？
     *
     * dp[i][j]表示对于前i个物品且当前背包容量为j时, 若值为true ,则表示正好装满, 否则false.
     * 求dp[N][SUM/2]        basecase: dp[x][0] = true 表示背包没空间, 相当于满,  dp[0][x] = false 表示没有物品可选择, 无法装满
     */
    public boolean canPartition(int[] nums) {
        //求和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int W = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        //初始化 base case
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;     //dp[x][0]表示背包没空间, 相当于满
        }
        //状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                //物品数组从0开始 所以要减一
                if (j - nums[i - 1] < 0) {     //如果背包剩余容量小于当前物品容量, 表示不能装入
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //前面一个物品时就已经装满了 或者 还需要装入
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][W];
    }

    /**
     * 因为dp[i][j]只与dp[i-1][x]有关,  进行状态压缩节省空间
     *
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        //求和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int W = sum / 2;
        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;     //dp[x][0]表示背包没空间, 相当于满
        //状态转移
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= W; j--) {  //需要反向遍历,以免之前的结果影响其他的结果
                //物品数组从0开始 所以要减一
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[W];
    }

    /**
     * 322. 零钱兑换
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
     * 每种硬币的数量是无限的。
     *
     * 转换为背包问题,每个物品都可以无限使用，但是要求背包必须装满，而且要求背包中的物品数目最少
     * dp[i]代表当钱包的总价值为j时，所需要的最少硬币的个数
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];       //dp[i]代表当钱包的总价值为j时，所需要的最少硬币的个数
        Arrays.fill(dp,Integer.MAX_VALUE);  //初始化
        dp[0] = 0;                          //basecase
        for (int coin : coins) {            //从小硬币开始, 防止漏掉情况,
            for (int i = coin; i <= amount; i++) {
                if(dp[i-coin] != Integer.MAX_VALUE) {   //必须,表示当前amount能被coin组合,比如coin2不能从dp[1]开始组合
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1:dp[amount];
    }

    /**
     * 3.完全背包
     * 518. 零钱兑换 II
     * 整数数组coins表示不同面额的硬币，整数 amount 表示总金额。求可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * 假设每一种面额的硬币有无限个。
     *
     * 背包问题: 容量amount, 物品重量coins[i],每个物品数量不限制(区别), 多少种方法把背包装满
     * 状态为 背包容量 和 可选物品  选择为 是否装进背包
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //dp[i][j]表示只使用前i个物品, 当背包容量为j时, 有value种方法装满
        int[][] dp = new int[n+1][amount+1];    //base case dp[0][x]=0表示不使用硬币无法开凑
        for (int i = 0; i <=n ; i++) {
            dp[i][0] = 1;           //base case dp[x][0]=1 表示目标金额外0时唯一的凑齐方法
        }
        for (int i = 1; i <= n; i++) {  //从小硬币开始, 防止漏掉情况
            for (int j = 1; j <= amount; j++) {
                if( j - coins[i-1] < 0){    //当前硬币太大, 无法凑, 沿用上一个物品的情况
                    dp[i][j] = dp[i-1][j];
                }else{      //状态转移方程
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     * dp[i][x]只与dp[i-1][x]有关, 状态压缩
     */
    public int change1(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if( j - coins[i] >= 0){
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
//        System.out.println(new Backpack().canPartition(new int[]{1, 2, 5}));
        System.out.println(new Backpack().coinChange(new int[]{1, 2, 5}, 100));
    }
}
