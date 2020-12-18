package LinkedList;

public class ReverseList2 {

    ListNode successor = null;
    public ListNode solution(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseTopN(head,n);
        }
        head.next = solution(head.next,m-1,n);
        return head;
    }

    /**
     * 反转前N个节点
     */
    public ListNode reverseTopN(ListNode head,int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode node = reverseTopN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return node;
    }
}
