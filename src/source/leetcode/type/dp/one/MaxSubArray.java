package source.leetcode.type.dp.one;

/**
 * 动态规划一
 * 53. 最大子数组和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 */
public class MaxSubArray {
    /**
     * 无法使用滑动窗口, 因为允许负数, 不知何时缩小窗口
     * dp[i]表示以num[i]结尾的子数组和最大和 不一定从头开始
     */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];    //第一个元素前面没有子数组 , 和就是自己 也是base case
        int max = dp[0];    //因为结果并不是最后一个dp状态, 需要记录最大的dp状态
        for (int i = 1; i < n; i++) {   //状态转移式
            //如果num[i]比加上前面的连续子数组最大和 大 , 则断开与前面数组的相加;
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
    /**
     * 因为dp[i] 只与dp[i-1]有关, 改进空间消耗
     */
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int dp_front = nums[0]; //第一个元素前面没有子数组 , 和就是自己 也是base case
        int dp_back;
        int max = dp_front;    //因为结果并不是最后一个dp状态, 需要记录最大的dp状态
        for (int i = 1; i < n; i++) {   //状态转移式
            //如果num[i]比加上前面的连续子数组最大和 大 , 则断开与前面数组的相加;
            dp_back = Math.max(nums[i], dp_front+nums[i]);
            if(dp_back > max){
                max = dp_back;
            }
            dp_front = dp_back;
        }
        return max;
    }
}
