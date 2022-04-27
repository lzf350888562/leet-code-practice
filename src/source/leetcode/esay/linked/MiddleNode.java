package source.leetcode.esay.linked;

import static source.leetcode.esay.linked.MergeTwoLists.ListNode;
/**
 * 876. 链表的中间结点
 * 拓展 链表二分可采用该方法获取中间节点
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 就在中间位置
        return slow;
    }
}
