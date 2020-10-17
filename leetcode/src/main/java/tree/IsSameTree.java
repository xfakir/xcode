package tree;

/**
 * 给定两个二叉树，判断是否为相同的树
 */
public class IsSameTree {
    public boolean solution(TreeNode p, TreeNode q){
        if(p == null && q == null) {
            return true;
        }
        if((p == null && q!=null) || (p!=null && q==null)){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return solution(p.left,q.left) && solution(p.right,q.right);
    }
}
