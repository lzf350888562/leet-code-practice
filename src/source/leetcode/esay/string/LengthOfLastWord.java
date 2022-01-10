package source.leetcode.esay.string;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * @author Jinx
 * @Date 2021/3/26
 */
public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		String[] strings = s.split(" ");
		if (strings.length==0)
			return 0;
		return strings[strings.length-1].length();
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(""));
	}
}
