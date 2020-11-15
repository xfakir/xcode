package twoPointers;

import tree.ListNode;

public class DetectCycle {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if (fast==null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
