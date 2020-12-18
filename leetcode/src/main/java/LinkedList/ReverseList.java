package LinkedList;

public class ReverseList {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode p = head;
        ListNode next;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public ListNode recursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
