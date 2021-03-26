package source.leetcode.esay.normal;

/**
 * 回文数
 * @author Jinx
 * @Date 2021/3/22
 */
public class IsPalindrome {
	public boolean isPalindrome(int x) {
		int f=x;
		int n =0;
		while(x!=0){
			n = n*10 + x%10;
			x = x/10;
		}
		return n==f;
	}
}
