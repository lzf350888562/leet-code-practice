package source.leetcode.esay.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. 杨辉三角 II  获取杨辉三角形指定行
 * @author Jinx
 * @Date 2021/3/27
 */
public class GenerateRow {
	public List<Integer> getRow(int rowIndex) {
		Integer[] dp = new Integer[rowIndex + 1];
		Arrays.fill(dp,1);
		for(int i = 2;i < dp.length;i++){
			for(int j = i - 1;j > 0;j--)
				dp[j] = dp[j] + dp[j - 1];
		}
		List<Integer> res = Arrays.asList(dp);
		return res;
	}
}
