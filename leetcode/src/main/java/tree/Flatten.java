package tree;

/**
 * 将二叉树原地展开为单链表
 */
public class Flatten {
    public void solution(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode left = root.left;
                TreeNode right = root.right;
                root.right = left;
                root.left = null;
                while(left.right != null) {
                    left = left.right;
                }
                left.right = right;
            }
            root = root.right;
        }
    }

    /**
     * 对于二叉树
     *      1
     *    2   5
     *  3  4    6
     *
     * 先序遍历1-2-3-4-5-6 依次将每个节点right指向后一个，这样会造成right节点值丢失
     * 因此可以倒序遍历
     * 依次将当前节点的right指向上一个节点
     *
     * 对于6-5-4-3-2-1来说，是一种变形的后序遍历
     * 即先right再left
     *
     * @param root
     */
    private TreeNode pre = null;
    public void solution_recursion(TreeNode root) {
        if(root == null) return;
        solution_recursion(root.right);
        solution_recursion(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
