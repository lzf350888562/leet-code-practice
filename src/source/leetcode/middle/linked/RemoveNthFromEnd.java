package source.leetcode.middle.linked;

import java.util.Stack;

import  static source.leetcode.esay.linked.MergeTwoLists.ListNode;

/**
 * 19
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 3种方法 计算链表长度(需要遍历两次)  栈  快慢指针(最快)
 * @author lzf
 * @date 2021/10/6
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node=head;
        Stack<ListNode> stack = new Stack<>();
        while(node.next!=null){
            stack.push(node);
            node=node.next;
       }
        for (int i = 0; i < n-1; i++) {
            stack.pop();
        }
        if(stack.isEmpty()){
            return head.next;
        }
        stack.peek().next = stack.peek().next.next;
        return head;
    }
    
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode res = new RemoveNthFromEnd().removeNthFromEnd(listNode, 2);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
