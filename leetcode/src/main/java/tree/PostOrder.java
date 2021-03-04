package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    public List<Integer> postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        LinkedList<Integer> list = new LinkedList<>();
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                //头插法
                list.addFirst(root.val);
                if(root.left!=null)
                    stack.push(root.left);
                //优先访问右子树
                root = root.right;
            }else {
                root = stack.pop();
            }
        }
        return list;
    }
}
