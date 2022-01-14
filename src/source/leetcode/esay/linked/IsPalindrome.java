package source.leetcode.esay.linked;

import static source.leetcode.esay.linked.MergeTwoLists.ListNode;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class IsPalindrome {
    /**
     * 先使用快慢指针找到链表中点，再把链表切成两半；然后把后半段反转；最后比较两半是否相等。
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //快慢指针找到链表中点
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = head, right = slow.next;
        //翻转后半段
        ListNode tmp = null;
        ListNode front = null, back = right;
        while (back != null){
            tmp = back.next;
            back.next = front;
            front = back;
            back = tmp;
        }
        right = front;
        //比较
        while ( left !=null & right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(0);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;
        System.out.println(new IsPalindrome().isPalindrome(l1));
    }
}
