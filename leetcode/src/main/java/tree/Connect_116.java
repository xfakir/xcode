package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点
 */
public class Connect_116 {
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
        Node pre = null;
        //每一层链表头节点
        Node head = root;
        while (cur.left != null) {
            cur.left.next = cur.right;
            if (pre != null) {
                pre.next = cur.left;
            }
            pre = cur.right;
            if (cur.next == null) {
                cur = head.left;
                head = cur;
                pre = null;
            } else {
                cur = cur.next;
            }
        }
        return root;
    }

    public Node solution_recursion(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null)
            return;
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }

    public Node solution_recursion_better_version(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        }
        solution_recursion_better_version(root.left);
        solution_recursion_better_version(root.right);
        return root;
    }
}
