package source.leetcode.esay.num;

/**
 * 翻转数字
 * @author Jinx
 * @Date 2021/3/21
 */
public class ReverseNumber {
	public static int reverse(int x) {
		long n =0;
		while(x!=0){
			n = n*10 + x%10;
			x = x/10;
		}
		return  (int)n==n?(int)n:0;
	}

	public static void main(String[] args) {
		System.out.println(reverse(612));
	}
}
