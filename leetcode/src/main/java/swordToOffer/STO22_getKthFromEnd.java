package swordToOffer;

import LinkedList.ListNode;

public class STO22_getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode next = head;
        int i = 1;
        while (next.next != null) {
            if (i >= k) {
                pre = pre.next;
            }
            next = next.next;
            i++;
        }
        return pre;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode pre = head;
        ListNode next = head;
        while (next != null) {
            next = next.next;
            if (k == 0) {
                pre = pre.next;
            } else {
                k--;
            }
        }
        return pre;
    }
}
