package source.leetcode.type.dp.one;

import java.util.Arrays;

/**
 * 动态规划一
 * 300. 最长递增子序列   子序列不一定是连续的
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */
public class LengthOfLIS {
    /**
     * 动态规划 dp[i] 表示以nums[i]结尾的最长递增序列长度值
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);      //base case
        for (int i = 1; i < nums.length; i++) {
            // 计算前面以nums[i]结尾的子序列的最大长度
            for (int j = 0; j < i; j++) {
                //只要找到前面那些结尾比nums[i]小的子序列，然后把nums[i]接到最后，就可以形成一个新的递增子序列，而且这个新的子序列长度加一。
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
