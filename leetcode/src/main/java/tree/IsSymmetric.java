package tree;

import java.util.LinkedList;

public class IsSymmetric {
    public boolean isSymmetric_recursion(TreeNode root) {
        if (root == null) return true;
        return recursion(root.left,root.right);
    }

    public boolean recursion(TreeNode left,TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return recursion(left.left,right.right) && recursion(left.right,right.left);
    }

    public boolean isSymmetric_iteration(TreeNode root) {
        if (root == null || (root.left == null && root.right ==null)) return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root.left);
        list.add(root.right);
        while (!list.isEmpty()) {
            TreeNode left = list.removeFirst();
            TreeNode right = list.removeFirst();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            list.add(left.left);
            list.add(right.right);

            list.add(left.right);
            list.add(right.left);

        }
        return true;
    }
}

