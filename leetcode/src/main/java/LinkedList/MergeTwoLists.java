package LinkedList;

public class MergeTwoLists {
    public ListNode solution(ListNode l1, ListNode l2) {
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

    public ListNode solution_recursion(ListNode l1,ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = solution_recursion(l1.next,l2);
            return l1;
        } else {
            l2.next = solution_recursion(l1,l2.next);
            return l2;
        }
    }
}
