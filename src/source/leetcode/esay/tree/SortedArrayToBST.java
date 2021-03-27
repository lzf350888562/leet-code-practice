package source.leetcode.esay.tree;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * @author Jinx
 * @Date 2021/3/27
 */
public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		int len = nums.length;
		if (len == 0){
			return null;
		}
		int mid = len/2;
		int [] leftArray = Arrays.copyOfRange(nums,0,mid);
		int [] rigthArray = Arrays.copyOfRange(nums,mid+1,len);
		return new TreeNode(nums[mid],sortedArrayToBST(leftArray),sortedArrayToBST(rigthArray));
	}
}
