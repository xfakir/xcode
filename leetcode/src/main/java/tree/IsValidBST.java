package tree;

/**
 * 验证是否为二叉搜索树
 */
public class IsValidBST {
    /**
     * 错误算法，未考虑右子节点小于根节点的情况 如
     *      10
     *    5    15
     *       6    20
     * 节点6虽然比15小但也小于10，因此仍不满足二叉搜索树条件
     * 因此不能简单将左节点与当前节点比较，因判断左节点或右节点是否在一个范围内，如6是否在(10,15)内
     * @param root
     * @return
     */
    public boolean solution_error(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return solution_error(root.left) && solution_error(root.right);

    }

    private long min = Long.MIN_VALUE;
    private long max = Long.MAX_VALUE;

    /**
     * 递归
     * @param root
     * @return
     */
    public boolean solution_recursion(TreeNode root) {
        return recursion(root,min,max);
    }
    public boolean recursion(TreeNode root , long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min)
            return false;

        return recursion(root.left,min,root.val) && recursion(root.right,root.val,max);
    }

    TreeNode pre = null;

    /**
     * 根据二叉搜索树性质，中序遍历一定是有序的，因此只需判断当前节点是否大于中序遍历的前一个节点，如果不大于返回false
     * @param root
     * @return
     */
    public boolean solution_inorder(TreeNode root) {
        if (root == null) return true;
        if(!solution_inorder(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        return solution_inorder(root.right);
    }
}
