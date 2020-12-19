package LinkedList;

public class InsertionSortList {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pos = dummy.next;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val >= pre.val) {
                cur = cur.next;
                pre = pre.next;
                continue;
            }

            if (cur.val <= dummy.next.val) {
                ListNode temp = cur.next;
                cur.next = dummy.next;
                dummy.next = cur;
                cur = temp;
                pre.next = cur;
                continue;
            }
            ListNode temp = cur.next;
            pre.next = cur.next;
            while (pos != pre) {
                if (pos.val < cur.val && pos.next.val >= cur.val) {
                    cur.next = pos.next;
                    pos.next = cur;
                }
                pos = pos.next;
            }
            pos = dummy.next;
            cur = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(4);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(1);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        InsertionSortList i = new InsertionSortList();
        i.solution(p1);
    }
}
