package source.leetcode.esay.string;

/**
 * 最长公共前缀
 * @author Jinx
 * @Date 2021/3/22
 */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs==null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int n=0;
		for (int i = 0;; i++) {
			char c;
			if (strs[0].length()<=n){
				return sb.toString();
			}else {
				c = strs[0].charAt(i);
			}
			for (int j = 1; j <strs.length; j++) {
				if (strs[j].length()<=n){
					return sb.toString();
				}else if(strs[j].charAt(i)!=c){
					return sb.toString();
				}
			}
			n++;
			sb.append(c);
		}
	}

	public static void main(String[] args) {
		String[] s={"a"};
		System.out.println(longestCommonPrefix(s));
	}
}
