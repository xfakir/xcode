package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树
 */
public class Connect_117 {
    public Node solution_with_queue(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
                node.next = pre;
                pre = node;
            }
        }
        return root;
    }

    /**
     * 不使用队列，将每一行看作链表，从而当前行处理下一行
     * @param root
     * @return
     */
    public Node solution_without_queue(Node root) {
        if (root == null) return null;
        //当前节点，即上一层节点
        Node cur = root;
        //下一层前节点
        Node pre = new Node(0);
        //每一层链表头节点
        Node head = pre;
        while (cur != null) {
            while(cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = head.next;
            pre = new Node(0);
            head = pre;
        }
        return root;
    }

    public Node solution_recursion(Node root) {
        if (root == null) return root;
        if (root.left != null && root.right != null) // 两儿子相连
            root.left.next = root.right;

        if (root.left != null && root.right == null) // 左儿子连接右方(右儿子必须null)
            root.left.next = getNode(root.next);
        if (root.right != null) // 右儿子连接右方(注意：左儿子不管是否null皆可！)
            root.right.next = getNode(root.next);

        // 随着深度增加，同一层需要连接的两节点距离可能越来越远并超出距离
        // 以上算法只有在两节点的父亲是兄弟的情况正确，到达很深的位置时，
        // 左边向右连接需要右边部分的情况，所以需要先递归右边？？？？？
        // 根本原因：连接方向从左到右！
        solution_recursion(root.right);
        solution_recursion(root.left);
        return root;
    }
    // 以root为起点，获取下一层的最靠左的节点
    public Node getNode(Node node) {
        if (node == null) return null;
        if (node.left != null) return node.left;
        if (node.right != null) return node.right;
        return getNode(node.next);
    }
}
