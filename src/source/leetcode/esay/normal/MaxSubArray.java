package source.leetcode.esay.normal;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * @author Jinx
 * @Date 2021/3/23
 */
public class MaxSubArray {
	public static int maxSubArray(int[] nums) {
		int res = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum > 0)
				sum += num;
			else    //如果前面的一部分和是负数 则没必要与后面的相加
				sum = num;
			res = Math.max(res, sum);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
}
