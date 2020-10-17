package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 中序后序构建二叉树
 */
public class BuildTree_106 {
    private Map<Integer,Integer> map;
    public TreeNode solution(int[] inorder,int[] postorder) {
        map = createMap(inorder);
        return recursion(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode recursion(int[] inorder,int in_left,int in_right,int[] postorder,int post_left,int post_right) {
        if (post_left > post_right || in_left > in_right) return null;
        if (post_left == post_right) return new TreeNode(postorder[post_right]);
        int index = map.get(postorder[post_right]);
        int left_tree_length = index-in_left;
        TreeNode node = new TreeNode(inorder[index]);
        node.left = recursion(inorder,in_left,index,postorder,post_left,post_left+left_tree_length-1);
        node.right = recursion(inorder,index+1,in_right,postorder,post_left+left_tree_length,post_right-1);
        return node;
    }

    public HashMap<Integer,Integer> createMap(int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return map;
    }
}
