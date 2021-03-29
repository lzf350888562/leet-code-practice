import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 给你一个 严格升序排列的正整数数组 arr和一个整数k。

 请你找到这个数组里第k个缺失的正整数。


 示例 1：

 输入：arr = [2,3,4,7,11], k = 5
 输出：9
 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 示例 2：

 */
public class Main2 {
	public static void main(String[] args) {
		int[] arr = new int[]{2,3,4,7,11};
		int k=5;
		System.out.println(f(arr,k));
	}
	public static int f(int[] arr,int k){
		boolean flag=false;
		int n=0;
		int num = 1;
		for (int index=0; !flag ; num++) {
			if (num>=arr[index]){
				index++;
			}else {
				n++;
			}
			if (n==k){
				flag=true;
			}
		}
		return num-1;
	}
}
