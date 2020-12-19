package LinkedList;

public class ReorderList {
    public void solution(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        slow = reverse(mid);
        fast = head;
        ListNode temp;
        while (slow != null) {
            temp = slow;
            slow = slow.next;
            temp.next = fast.next;
            fast.next = temp;
            fast = temp.next;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode p = head;
        ListNode next;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        return slow;
    }
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        //p2.next = p3;
        //p3.next = p4;
        //p4.next = p5;
        ReorderList r = new ReorderList();
        r.midNode(p1);
    }
}
