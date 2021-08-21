package source.leetcode.esay.normal;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * @author lzf
 * @Date 2021/8/21
 */
public class HasCycle {
	//快慢指针
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (true){
			try{
				slow = slow.next;
				fast = fast.next.next;
			}catch (Exception e){
				return false;
			}
			if (slow == fast)
				return true;
		}
	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
