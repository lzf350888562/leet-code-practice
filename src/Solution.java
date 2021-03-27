
import java.util.Stack;


/**
 * @author Jinx
 * @Date 2021/3/20
 */
public class Solution {
	public static String longestPalindrome(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		String string = "";
		for (int i = 0; i <s.length() ; i++) {
			stack.clear();
			result.delete(0,result.length());
			for (int j = i; j < s.length(); j++) {
				Character c = s.charAt(j);
				if (stack.isEmpty()){
					stack.push(c);
					result.append(c);
				} else if (stack.peek().equals(c)){
					stack.pop();
				}else {
					stack.push(c);
					result.append(c);
				}
			}
			if (stack.size()<2){
				if (result.length()>string.length()){
					string=result.toString();
				}
			}
		}

		return string;
	}
	public static void main(String[] args){
		System.out.println(longestPalindrome("babad"));
	}
}
