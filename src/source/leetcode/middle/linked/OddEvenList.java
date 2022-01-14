package source.leetcode.middle.linked;

import source.leetcode.esay.linked.IsPalindrome;

import java.util.LinkedList;

import static source.leetcode.esay.linked.MergeTwoLists.ListNode;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * 应当保持奇数节点和偶数节点的相对顺序。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode p1=odd,p2=even,p=head;
        int count = 0;
        while (p != null) {
            count++;
            if(count%2 ==1){
                p1.next = p;
                p1 = p1.next;
            }else{
                p2.next = p;
                p2 = p2.next;
            }
            p=p.next;
        }
        p2.next = null;
        p1.next = even.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        System.out.println(new OddEvenList().oddEvenList(l1));
    }
}
