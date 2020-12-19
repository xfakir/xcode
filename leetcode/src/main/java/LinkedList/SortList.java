package LinkedList;

public class SortList {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preMid = midNode(head);
        ListNode midNode = preMid.next;
        preMid.next = null;
        ListNode leftNode = solution(head);
        ListNode rightNode = solution(midNode);

        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode p = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return node.next;
    }

    private ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
