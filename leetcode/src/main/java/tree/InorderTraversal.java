package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树
 */
public class InorderTraversal {
    /**
     * 解法一：递归法
     * @param root
     * @return
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root,list);
        return list;
    }

    public void recursion(TreeNode node, List<Integer> list) {
        if(node == null) return;
        recursion(node.left,list);
        list.add(node.val);
        recursion(node.right,list);
    }

    /**
     * 解法二：迭代
     * 自己实现，算法缺点：改变了传入的参数root
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(root != null || !stack.empty()) {
            if (root == null) {
                root = stack.pop();
                root.left = null;
            }
            if (root.left != null) {
                stack.push(root);
                root = root.left;
            } else  {
                list.add(root.val);
                /*if (root.right != null) {
                    list.add(root.val);
                    root = root.right;
                } else {
                    root = null;
                }*/
                root = root.right;
            }
        }
        return list;
    }

    /**
     * 解法二:better code
     * @param root
     * @return
     */
    public List<Integer> solution3(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(stack.size() > 0 || root != null){
            if(root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                tree.add(node.val);
                root = node.right;
            }
        }
        return tree;
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();

        //test1
        /*List<Integer> result = inorderTraversal.solution1(TreeNode.createTree());
        for (Integer i: result) {
            System.out.print(i + " ");
        }*/
        //test2
        List<Integer> result = inorderTraversal.solution1(TreeNode.createTree());
        for (Integer i: result) {
            System.out.print(i + " ");
        }
    }
}
