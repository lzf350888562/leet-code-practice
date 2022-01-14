package source.leetcode.esay.linked;

import static source.leetcode.esay.linked.MergeTwoLists.ListNode;

/**
 * 206. 反转链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode front = null, back = head;
        while (back != null){
            ListNode tmp = back.next;
            back.next = front;
            front = back;
            back = tmp;
        }
        return front;
    }
}
