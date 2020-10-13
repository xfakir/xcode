package tree;

import java.util.*;

/**
 * 二叉树锯齿形层次遍历
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> solution_iteration(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> solution_recursion(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        recursion(1,root,result);
        return result;
    }

    public void recursion(Integer index,TreeNode node,List<List<Integer>> result) {
        if (result.size() < index) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            result.add(linkedList);
        }
        if(index%2 != 0) {
            result.get(index - 1).add(node.val);
        } else {
            result.get(index - 1).add(0,node.val);
        }

        if (node.left != null) {
            recursion(index+1,node.left,result);
        }
        if (node.right != null) {
            recursion(index+1,node.right,result);
        }

    }
}
