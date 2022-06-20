package source.leetcode.esay.string;

import java.util.Arrays;

/**
 * 14. 最长公共前缀
 * @author Jinx
 * @Date 2021/3/22
 */
public class LongestCommonPrefix {
	/**
	 * 写的时间太久了, 自己都看不懂了 - -
	 */
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

	/**
	 * 利用公共前缀不会比任何一个字符串长的特性, 从后一个个减...
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix1(String[] strs) {
		String maxPrefix = strs[0];
		for (int j = 1; j < strs.length; j++) {
			while(!strs[j].startsWith(maxPrefix)){
				if( maxPrefix.length() == 0 )return "";
				//公共前缀不匹配就让它变短！
				maxPrefix = maxPrefix.substring(0, maxPrefix.length()-1);
			}
		}
		return maxPrefix;
	}
	/**
	 * 利用字典序方式, 比较最小和最大的即可...
	 */
	public static String longestCommonPrefix2(String[] strs) {
		Arrays.sort(strs);
		if(strs[0].length() == 0){
			return "";
		}
		for (int i = 0; i < strs[0].length(); i++){
			String subStr = strs[0].substring(0,strs[0].length()-i);
			if(strs[strs.length-1].startsWith(subStr)){
				return subStr;
			}
		}
		return "";
	}

	public static void main(String[] args) {
		String[] s={"flower","flow","flight"};
		System.out.println(longestCommonPrefix1(s));
	}
}
