package tree;

/**
 * 获得二叉树的最大深度
 */
public class MaxDepth {
    /**
     * 自底向上
     * @param root
     * @return
     */
    public int solution_bottom_to_top(TreeNode root) {
        if (root == null) return 0;
        return Math.max(solution_bottom_to_top(root.left), solution_bottom_to_top(root.right)) + 1;
    }

    /**
     * 自顶向下
     * @param root
     * @return
     */
    public int solution_top_to_bottom(TreeNode root) {
        return recursion(root,0);
    }

    public int recursion(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(recursion(node.left,depth+1),recursion(node.right,depth+1));
    }
}
