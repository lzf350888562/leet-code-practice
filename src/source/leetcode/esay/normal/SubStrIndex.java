package source.leetcode.esay.normal;

/**
 * 第一次出现的子串的位置
 * @author Jinx
 * @Date 2021/3/23
 */
public class SubStrIndex {
	public static int strStr(String haystack, String needle) {
		if ("".equals(needle))
			return 0;
		if (haystack.length()<needle.length())
			return -1;
		for(int i=0;i<haystack.length()-needle.length()+1;i++)
		{
			int j=0;
			for(;j<needle.length();j++)
			{
				if(haystack.charAt(i+j)!=needle.charAt(j)){
					break;
				}
			}
			if(j==needle.length()){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(strStr("mississippi","issipi"));
	}
}
