package source.leetcode.esay.array;

/**
 * 删除有序数组的重复项 不新建数组
 * @author Jinx
 * @Date 2021/3/22
 */
public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		if (nums.length==0){
			return 0;
		}
		int t = nums[0]-1;
		for (int i = 1,n=nums[0]; i < nums.length; i++) {
			if (nums[i]==n){
				nums[i]=t;
			}else {
				n=nums[i];
			}
		}
		//下面这段代码可作为移除数组中指定元素用
		int j=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=t){
				nums[j++]=nums[i];
			}
		}
		return j;
	}
}
