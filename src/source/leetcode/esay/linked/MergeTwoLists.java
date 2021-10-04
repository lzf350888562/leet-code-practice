package source.leetcode.esay.linked;

/**
 * 合并两个有序链表
 * @author Jinx
 * @Date 2021/3/22
 */
public class MergeTwoLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode listNode=new ListNode();
		ListNode headd=listNode;
		while (l1!=null&&l2!=null){
			if(l1.val<l2.val){
				listNode.next=l1;
				l1=l1.next;
			}else {
				listNode.next=l2;
				l2=l2.next;
			}
			listNode=listNode.next;
		}
		while (l1!=null){
			listNode.next=l1;
			l1=l1.next;
			listNode=listNode.next;
		}
		while (l2!=null){
			listNode.next=l2;
			l2=l2.next;
			listNode=listNode.next;
		}
		return headd.next;
	}

	public static class ListNode {
       public int val;
      public ListNode next;
      ListNode() {}
       ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
