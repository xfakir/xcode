package twoPointers;

import tree.ListNode;

public class Partition {
    public ListNode solution(ListNode head, int x) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first;
        //找到第一个最后一个小于x的node
        first =dummy;
        while (first.next !=null && first.next.val <x){
            first = first.next;
        }



        ListNode second=first;
        ListNode temp1;
        ListNode temp2;
        while (second!=null && second.next != null) {
            if (second.next.val < x) {
                temp1 = second.next;
                second.next = temp1.next;
                temp2 = first.next;
                first.next = temp1;
                temp1.next = temp2;
                first = first.next;
            } else {
                second=second.next;
            }
        }
        return dummy.next;
    }
}
