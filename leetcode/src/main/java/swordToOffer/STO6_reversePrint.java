package swordToOffer;

import LinkedList.ListNode;

public class STO6_reversePrint {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        ListNode p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }

        int[] result = new int[length];
        p = head;
        for (int i = 0; i < length; i++) {
            result[length-i-1] = p.val;
            p = p.next;
        }
        return result;
    }
}
