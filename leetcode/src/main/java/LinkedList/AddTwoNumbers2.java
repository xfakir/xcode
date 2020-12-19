package LinkedList;

import java.util.Stack;

public class AddTwoNumbers2 {
    public ListNode solution(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        //Stack<Integer> stack3 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode sum = null;
        int digitSum = 0;
        int carry = 0;
        while (!stack1.empty() || !stack2.empty() || carry == 1) {
            int val1 = stack1.empty()?0:stack1.pop();
            int val2 = stack2.empty()?0:stack2.pop();
            digitSum = val1 + val2;
            if (carry == 1) {
                digitSum++;
                carry = 0;
            }
            if (digitSum >= 10) {
                digitSum = digitSum % 10;
                carry = 1;
            }
            ListNode node = new ListNode(digitSum);
            node.next = sum;
            sum = node;
            //stack3.push(digitSum);
        }
        /*while (!stack3.empty()) {
            curSum.next = new ListNode(stack3.pop());
            curSum = curSum.next;
        }*/
        return sum;
    }
}
