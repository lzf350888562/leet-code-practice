package source.leetcode.type.dp.one;

import java.util.Arrays;

/**
 * 动态规划一
 * 1143. 最长公共子序列        子序列不一定是连续的
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在返回0
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 */
public class LongestCommonSubsequence {
    /**
     * 动态规划
     * 对于两个字符串, 需要两个指针在各自上面移动,记录两个指针分别在不同位置的状态
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] forget = new int[length1][length2];  //减少重复操作, 也用于记录状态
        for (int i = 0; i < forget.length; i++) {
            Arrays.fill(forget[i],-1);
        }
        return dp(text1,0,text2,0,forget);
    }
    // 自顶向下 也可以改为自底向上
    private int dp(String text1, int i, String text2, int j, int[][] forget) {
        if(i == text1.length() || j == text2.length()){
            return 0; //base case;
        }
        if(forget[i][j] != -1 ){
            return forget[i][j];
        }
        //分情况处理
        if(text1.charAt(i) == text2.charAt(j)){
            forget[i][j] = 1 + dp(text1,i+1,text2,j+1,forget);
        }else{ // 从后面寻找
            forget[i][j] = Math.max(dp(text1,i+1,text2,j,forget),dp(text1,i,text2,j+1,forget));
        }
        return forget[i][j];
    }
}
