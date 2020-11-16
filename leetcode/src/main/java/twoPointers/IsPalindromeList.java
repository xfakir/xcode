package twoPointers;

import tree.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题
 *
 */
public class IsPalindromeList {
    public boolean solution(ListNode head) {
        ListNode fast = head, slow = head;
        //通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半部分链表
        slow = reverse(slow);

        fast = head;
        while (slow != null) {
            //然后比较，判断节点值是否相等
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
