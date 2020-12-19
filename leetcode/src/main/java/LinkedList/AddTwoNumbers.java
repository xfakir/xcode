package LinkedList;

public class AddTwoNumbers {
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode curSum = sum;
        int digitSum = 0;
        int carry = 0;
        while (l1 != null && l2 != null) {
            digitSum = l1.val + l2.val;
            if (carry == 1) {
                digitSum++;
                carry=0;
            }
            if (digitSum >= 10) {
                digitSum = digitSum % 10;
                carry = 1;
            }
            curSum.next = new ListNode(digitSum);
            curSum = curSum.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            digitSum = l1.val;
            if (carry == 1) {
                digitSum++;
                carry = 0;
            }
            if (digitSum >= 10) {
                digitSum = digitSum % 10;
                carry = 1;
            }
            curSum.next = new ListNode(digitSum);
            curSum = curSum.next;
            l1 = l1.next;

        }

        while (l2 != null) {
            digitSum = l2.val;
            if (carry == 1) {
                digitSum++;
                carry = 0;
            }
            if (digitSum >= 10) {
                digitSum = digitSum % 10;
                carry = 1;
            }
            curSum.next = new ListNode(digitSum);
            curSum = curSum.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            curSum.next = new ListNode(1);
        }
        return sum.next;

    }
}
