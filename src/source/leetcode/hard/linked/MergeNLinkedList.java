package source.leetcode.hard.linked;

import source.leetcode.esay.linked.MergeTwoLists;
import source.leetcode.esay.linked.MergeTwoLists.ListNode;

/**
 * no.24 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeNLinkedList {
    // 归并归并
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 2){
            return new MergeTwoLists().mergeTwoLists(lists[0],lists[1]);
        }
        int length = lists.length;
        int mid = length / 2;
        ListNode[] left = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = lists[i];
        }
        ListNode[] right = new ListNode[length-mid];
        for (int i = mid; i < length; i++) {
            right[i-mid] = lists[i];
        }
        return new MergeTwoLists().mergeTwoLists(mergeKLists(left),mergeKLists(right));
    }

}
