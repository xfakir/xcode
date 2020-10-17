package tree;

/**
 * 有序链表转二叉树
 */
public class SortedListToBST {
    public TreeNode solution(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        System.out.println("total length: "+length);
        return binary(head,length);
    }
    public TreeNode binary(ListNode head,int length) {
        if (length == 0) return null;
        if (length == 1) return new TreeNode(head.val);;
        ListNode midNode = getMidNode(head,length);
        System.out.println("midNode: "+midNode.val);
        TreeNode node = new TreeNode(midNode.val);
        node.left = binary(head,length/2);
        node.right = binary(midNode.next,length-length/2-1);
        return node;
    }


    public ListNode getMidNode(ListNode head,int length) {
        ListNode node = head;
        for (int i = 0; i < length/2; i++) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        SortedListToBST sortedListToBST = new SortedListToBST();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        sortedListToBST.solution(node1);

    }
}
