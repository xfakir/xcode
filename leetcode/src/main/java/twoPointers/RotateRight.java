package twoPointers;

import tree.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 */
public class RotateRight {
    public ListNode solution(ListNode head, int k) {
        if (head==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        int length= 1;
        while (first.next != null) {
            first = first.next;
            length++;
        }
        first = head;
        ListNode second = first;
        if (k == length) return head;
        int gap = k%length;
        if (gap==0) return head;
        for (int i = 0; i < gap; i++) {
            second = second.next;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = dummy.next;
        dummy.next = first.next;
        first.next = null;
        return dummy.next;
    }

    public ListNode solution_better(ListNode head, int k) {
        if(head == null)
        {
            return null;
        }

        ListNode oldTail = head;
        //需要遍历具体长度
        int n=0;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        //连成环
        oldTail.next = head;
        //找新的尾巴结点
        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++)
        {
            newTail=newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next=null;
        return newHead;
    }
}
