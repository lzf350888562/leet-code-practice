package source.leetcode.esay.linked;
import java.awt.*;

import static source.leetcode.esay.linked.MergeTwoLists.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode node=head;
        while ( node!=null && node.next !=null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(0);
//        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = null;
        System.out.println(new DeleteDuplicates().deleteDuplicates(l1));
    }
}
