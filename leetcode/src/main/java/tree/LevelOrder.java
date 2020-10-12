package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    /**
     * 时间复杂度： O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_iteration(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while(queue.size()>0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(h)，h 是树的高度
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_recursive(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(1,root,res);
        return res;
    }

    void dfs(int index,TreeNode root, List<List<Integer>> res) {
        //假设res是[ [1],[2,3] ]， index是3，就再插入一个空list放到res中
        if(res.size()<index) {
            res.add(new ArrayList<Integer>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index-1).add(root.val);
        //递归的处理左子树，右子树，同时将层数index+1
        if(root.left!=null) {
            dfs(index+1, root.left, res);
        }
        if(root.right!=null) {
            dfs(index+1, root.right, res);
        }
    }

}
