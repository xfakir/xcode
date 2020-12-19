package LinkedList;

public class OddEvenList {
    public ListNode solution(ListNode head) {
        if (head==null || head.next == null) return head;
        ListNode evenList = new ListNode(0);
        ListNode curEven = evenList;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            curEven.next = temp;
            curEven = curEven.next;
            cur = cur.next == null?cur:cur.next;
            if (cur.next == null) {
                curEven.next = null;
            }
        }
        cur.next = evenList.next;
        return head;
    }
}
