package source.leetcode.esay.array;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不新建数组
 * @author Jinx
 * @Date 2021/3/22
 */
public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		if (nums.length==0){
			return 0;
		}
		//数组中重复的元素标记替换为t
		int t = nums[0]-1;
		for (int i = 1,n=nums[0]; i < nums.length; i++) {
			if (nums[i]==n){
				nums[i]=t;
			}else {
				n=nums[i];
			}
		}
		//删除t
		int j=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=t){
				nums[j++]=nums[i];
			}
		}
		return j;
	}
}
