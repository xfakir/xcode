package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树自底向上层次遍历
 */
public class LevelOrderBottom {


    public List<List<Integer>> solution_iteration(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(0,list);
        }
        return result;
    }

    public List<List<Integer>> solution_recursion(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        recursion(root,result,1);
        return result;
    }

    public void recursion(TreeNode node, List<List<Integer>> result,int index) {
        if (result.size() < index) {
            result.add(0,new ArrayList<>());
        }
        result.get(result.size() - index).add(node.val);
        if (node.left != null) recursion(node.left,result,index+1);
        if (node.right != null) recursion(node.right,result,index+1);
    }
}
