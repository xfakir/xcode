package twoPointers;

import tree.ListNode;

public class HasCycle {
    public boolean solution(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode pre = head;
        ListNode post = head.next;
        while (post != null && post.next != null) {
            if (post == pre) {
                return true;
            }
            pre = pre.next;
            post = post.next.next;
        }
        return false;
    }

    public  boolean solution_better(ListNode head) {
        if(head==null || head.next == null ){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            //保证每次移动两个位置的快指针 不指向null，或者他的下一个节点不是null
            if (fast==null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
