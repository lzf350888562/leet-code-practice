package source.leetcode.difficult.string;

import java.util.BitSet;
import java.util.LinkedList;

/**
 * no.32 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1); //最后一个没有被匹配的右括号的下标
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {   //如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新「最后一个没有被匹配的右括号的下标」   比如 ))()
                    stack.push(i);
                } else {                //如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
