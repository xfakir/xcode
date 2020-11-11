package twoPointers;

import tree.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 */
public class RemoveNthFromEnd {
    public ListNode solution(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode dummy = new ListNode(-1 );
        dummy.next = head;
        ListNode before = dummy;
        ListNode first = head;
        ListNode second = first;
        for (int i = 0; i < n; i++) {
            second = second.next;
        }
        while (second!=null) {
            second = second.next;
            first = first.next;
            before = before.next;
        }
        before.next = first.next;
        return dummy.next;
    }

    public ListNode solution_better(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode dummy = new ListNode(0 );
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy.next;
        for (int i = 0; i < n; i++) {
            second = second.next;
        }
        while (second!=null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
