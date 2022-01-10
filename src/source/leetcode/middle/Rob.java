package source.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 198打家劫舍
 * 数组 取不连续元素 求最大和
 * @author Jinx
 * @Date 2021/3/27
 */
public class Rob {

		Map<Integer,Boolean> A = new HashMap<>();
		Map<Integer,Integer> B = new HashMap<>();

		int f(int[] nums,int x){
			if (x>=nums.length)  return 0;
			if(A.containsKey(x)) return B.get(x);
			A.put(x,true);
			B.put(x,Math.max(f(nums,x+2)+nums[x],f(nums,x+1)));
			return B.get(x);
		}
		public int rob(int[] nums) {
			return f(nums,0);
		}







		//------------------------------------待完善



	private static Map<Integer,Integer> res=new HashMap<>();
	int f2(int[] nums,int x){
		if (x>nums.length)
			return 0;
		int a;
		if (res.containsKey(x+2)){
			a=res.get(x+2);
		}else {
			a=f(nums,x+2);
			res.put(x+2,a);
		}
		int b;
		if (res.containsKey(x+1)){
			b=res.get(x+1);
		}else {
			b=f(nums,x+1);
			res.put(x+1,b);
		}

		return Math.max(a,b);
	}
	int rob2(int[] nums,int x){

		if (x>=nums.length)return 0;
		if(A.containsKey(x)) return B.get(x);A.put(x,true);
		B.put(x,Math.max(f(nums,x+2)+nums[x],f(nums,x+1)));
		return B.get(x);
	}
}
