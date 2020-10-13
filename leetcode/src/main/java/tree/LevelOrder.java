package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    /**
     * 时间复杂度： O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_iteration(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return  result;
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(h)，h 是树的高度
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_recursion(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();
        recursion(1,root,result);
        return result;
    }

    void recursion(int index,TreeNode root, List<List<Integer>> result) {
        if (result.size() < index) {
            ArrayList<Integer> list = new ArrayList<>();
            result.add(list);
        }
        result.get(index-1).add(root.val);
        if (root.left != null) {
            recursion(index+1,root.left,result);
        }
        if (root.right != null) {
            recursion(index+1,root.right,result);
        }

    }

}
