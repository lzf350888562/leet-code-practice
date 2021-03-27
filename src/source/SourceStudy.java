package source;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jinx
 * @Date 2021/3/21
 */
public class SourceStudy {
	private static Map<Integer,Integer> res=new HashMap<>();
	int ef(int[] nums,int x){
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
	int f(int[] nums,int x){

		if (x>=nums.length)return 0;
		if(A.containsKey(x)) return B.get(x);A.put(x,true);
		B.put(x,Math.max(f(nums,x+2)+nums[x],f(nums,x+1)));
		return B.get(x);
	}
	Map<Integer,Boolean> A = new HashMap<>();
	Map<Integer,Integer> B = new HashMap<>();
	public static void main(String[] args) {

	}





}
