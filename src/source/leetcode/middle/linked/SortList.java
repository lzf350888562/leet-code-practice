package source.leetcode.middle.linked;

import static source.leetcode.esay.linked.MergeTwoLists.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 链表排序 归并: 一对一排序 二对二排序 ...
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode fast = node, slow = node, front = null;
        //递归的最底层只有一个节点
        while (fast != null && fast.next != null) {     //第一次肯定能执行, 因为方法开始判断了
            fast = fast.next.next;
            front = slow;
            slow = slow.next;
        }
        front.next = null;  //截断前面一半
        ListNode left = mergeSort(node);
        ListNode right = mergeSort(slow);
        //合并
        ListNode head = new ListNode();
        ListNode tmp = head;
        while(left !=null && right !=null){
            if(left.val < right.val){
                tmp.next = left;
                left = left.next;
            }else{
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        if(left!=null){
            tmp.next = left;
        }
        if(right!=null){
            tmp.next = right;
        }
        return head.next;
    }
}
