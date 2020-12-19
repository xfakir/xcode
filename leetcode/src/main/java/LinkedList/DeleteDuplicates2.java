package LinkedList;

public class DeleteDuplicates2 {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = pre.next;
        ListNode next = p.next;
        while (next != null) {
            if (p.val != next.val) {
                if (p.next == next) {
                    pre = p;
                } else {
                    pre.next = next;
                }
                p = next;
                next = next.next;
                continue;
            }
            next = next.next;
        }
        //[1,2,2] 即末尾是重复元素情况
        if (pre.next.next != null && pre.next.val == pre.next.next.val) {
            pre.next = next;
        }
        return dummy.next;
    }
}
