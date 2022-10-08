package classes5;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(TreeNode left, TreeNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
