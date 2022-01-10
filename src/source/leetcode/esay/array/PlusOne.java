package source.leetcode.esay.array;

/**
 * 66. 加一
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * @author Jinx
 * @Date 2021/3/26
 */
public class PlusOne {
	public static int[] plusOne(int[] digits) {
		boolean flag=false;
		for (int i = digits.length-1; i >=0&&!flag ; i--) {
			if (digits[i]==9){
				digits[i]=0;
			}else {
				digits[i]++;
				flag=true;
			}
		}
		if (flag)
			return digits;
		else {
			int[] nums = new int[digits.length+1];
			nums[0]=1;
			for (int i = 1; i <nums.length ; i++) {
				nums[i]=digits[i-1];
			}
			return  nums;
		}
	}

	public static void main(String[] args) {
		int[] digits = new int[]{9};
		digits = plusOne(digits);
		for (int digit : digits) {
			System.out.println(digit);
		}
	}
}
