package tree;

/**
 * 二叉树最小深度
 */
public class MinDepth {
    public int solution(TreeNode root) {
        if (root == null) return 0;
        int left = solution(root.left);
        int right = solution(root.right);
        if (left != 0 && right !=0) {
            return Math.min(left, right) + 1;
        }
        return left + right + 1;
    }
}
