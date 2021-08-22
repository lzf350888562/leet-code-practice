package source.leetcode.esay.linked;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * @author lzf
 * @Date 2021/8/22
 */
public class IntersectionNode {
	public MergeTwoLists.ListNode getIntersectionNode(MergeTwoLists.ListNode headA, MergeTwoLists.ListNode headB) {
		if(headA == null || headB == null) return null;
		MergeTwoLists.ListNode pA = headA, pB = headB;
		while(pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;
	}
}
