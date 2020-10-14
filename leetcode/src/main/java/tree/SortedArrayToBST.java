package tree;

/**
 * 有序数组转二叉搜索树
 */
public class SortedArrayToBST {
    public TreeNode solution_binary(int[] nums) {
        return binary(nums,0,nums.length-1);
    }
    public TreeNode binary(int[] nums,int left,int right) {
        if (left > right) return null;
        int mid = (right - left)/2 + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = binary(nums,left,mid-1);
        node.right = binary(nums,mid+1,right);
        return node;
    }

}
