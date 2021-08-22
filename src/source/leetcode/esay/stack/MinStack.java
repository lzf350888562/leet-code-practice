package source.leetcode.esay.stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * @author lzf
 * @Date 2021/8/22
 */
public class MinStack {
	private Node head;
	public void push(int x) {
		if(head == null)
			head = new Node(x, x);
		else
			head = new Node(x, Math.min(x, head.min), head);
	}
	public void pop() {
		head = head.next;
	}
	public int top() {
		return head.val;
	}
	public int getMin() {
		return head.min;
	}
	private class Node {
		int val;
		int min;   //记录以当前node为栈顶的栈的最小元素
		Node next;

		private Node(int val, int min) {
			this(val, min, null);
		}

		private Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}
}
