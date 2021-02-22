package swordToOffer;

import LinkedList.ListNode;

public class STO25_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        while (l1 != null) {
            curr.next = l1;
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            curr.next = l2;
            curr = curr.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
