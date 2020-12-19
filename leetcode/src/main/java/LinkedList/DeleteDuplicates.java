package LinkedList;

public class DeleteDuplicates {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode p;
        while (pre != null) {
            p = pre.next;
            while (p != null && p.val == pre.val) {
                p = p.next;
            }
            pre.next = p;
            pre = p;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head, fast = head;
        if (slow == null) return head;

        while (fast != null) {
            if (slow.val != fast.val) {
                slow = slow.next;
                slow.val = fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
