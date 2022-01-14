package source.leetcode.middle.linked;
import static source.leetcode.esay.linked.MergeTwoLists.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode front = new ListNode();
        ListNode p = null;
        ListNode tmp = null;
        while (head!=null && head.next!=null){
            if(p == null) {
                p = head.next;
            }
            tmp = head.next.next;
            head.next.next = head;
            front.next = head.next;
            head.next = tmp;
            front = front.next.next;
            head = tmp;
        }
        if( p == null) {    //说明循环没有进行, 只有一个节点
            return head;
        }
        //处理最后一个单节点
        front.next = tmp;
        return p;
    }
}
