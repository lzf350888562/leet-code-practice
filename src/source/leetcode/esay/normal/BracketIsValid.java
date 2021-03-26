package source.leetcode.esay.normal;

import java.util.ArrayList;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * 括号是否有效
 * @author Jinx
 * @Date 2021/3/22
 */
public class BracketIsValid {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		ArrayList<Character> arrayList= new ArrayList<>();
		for (int i = 0; i <s.length() ; i++) {
			arrayList.add(s.charAt(i));
		}
		arrayList.forEach(character -> {
			if (stack.isEmpty()){
				stack.push(character);
			}else if (stack.peek().equals('{')&&character.equals('}')){
				stack.pop();
			}else if (stack.peek().equals('(')&&character.equals(')')){
				stack.pop();
			}else if (stack.peek().equals('[')&&character.equals(']')){
				stack.pop();
			}else {
				stack.push(character);
			}
		});
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}
}
