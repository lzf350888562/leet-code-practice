package source.leetcode.esay.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * @author Jinx
 * @Date 2021/3/27
 */
public class IsPalindrome {
	public static boolean isPalindrome(String s) {
		if (s == null) return true;
		s = s.toLowerCase();
		int l = s.length();
		StringBuilder str = new StringBuilder(l);
		for (char c : s.toCharArray()) {
			if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
				str.append(c);
			}
		}
		return str.toString().equals(str.reverse().toString());
	}
}
