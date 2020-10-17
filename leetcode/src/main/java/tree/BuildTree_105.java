package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 前序中序构建二叉树
 */
public class BuildTree_105 {
    private Map<Integer,Integer> map;

    public TreeNode solution(int[] preorder,int[] inorder) {
        map = createMap(inorder);
        return recursion(preorder,0,preorder.length-1,inorder,0,inorder.length);
    }
    
    public TreeNode recursion(int[] preorder,int pre_left,int pre_right,int[] inorder,int in_left,int in_right) {
        if (pre_left > pre_right) return null;
        if (pre_left == pre_right) return new TreeNode(preorder[pre_left]);
        int index = getIndex(inorder,preorder[pre_left]);
        int left_tree_length = index - in_left;
        TreeNode node = new TreeNode(inorder[index]);
        node.left = recursion(preorder,pre_left+1,pre_left+left_tree_length,inorder,in_left,index);
        node.right = recursion(preorder, pre_left+left_tree_length+1,pre_right,inorder,index+1,in_right);
        return node;
    }

    public TreeNode recursionWithMap(int[] preorder,int pre_left,int pre_right,int[] inorder,int in_left,int in_right) {
        if (pre_left > pre_right) return null;
        if (pre_left == pre_right) return new TreeNode(preorder[pre_left]);
        int index = map.get(preorder[pre_left]);
        int left_tree_length = index - in_left;
        TreeNode node = new TreeNode(inorder[index]);
        node.left = recursion(preorder,pre_left+1,pre_left+left_tree_length,inorder,in_left,index);
        node.right = recursion(preorder, pre_left+left_tree_length+1,pre_right,inorder,index+1,in_right);
        return node;
    }

    public int getIndex(int[] inorder,int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public HashMap<Integer,Integer> createMap(int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return map;
    }
}
