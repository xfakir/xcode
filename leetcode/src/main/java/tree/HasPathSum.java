package tree;

/**
 * 给定一个树 是否有路径总和等于该数
 */
public class HasPathSum {
    public boolean solution(TreeNode root, int sum) {
        if (root == null) return false;
        int val = root.val;
        if (root.left == null && root.right == null && val == sum) return true;
        //注意这里是 或 ！！！
        return solution(root.left,sum-val) || solution(root.right,sum-val);
    }
}
