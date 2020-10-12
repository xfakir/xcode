package tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree() {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node.left = node2;
        node.right = node3;
        node2.right = node4;
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.createTree();

        //IsValidBST
        IsValidBST isValidBST  = new IsValidBST();
        System.out.println(isValidBST.solution_inorder(node));
    }
}
