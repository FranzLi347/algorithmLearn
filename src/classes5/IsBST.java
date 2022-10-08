package classes5;
/*
    如何判断一颗二叉树是搜索二叉树
    搜索二叉树：每一棵子树，左树的节点比父节点小，右树的节点比父节点大
 */
public class IsBST {
    static class ReturnType{
        int min;
        int max;
        boolean isBST;
        public ReturnType(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    public static boolean isBST(TreeNode root){
        return process(root).isBST;
    }

    public static ReturnType process(TreeNode root) {
        if (root == null) return null;

        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);
        int min = root.data;
        int max = root.data;
        if (leftData != null) {
            min = Math.min(min,leftData.min);
            max = Math.max(max,leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min,rightData.min);
            max = Math.max(max,rightData.max);
        }
        boolean isBST = true;
        if(leftData != null && (!leftData.isBST || root.data > leftData.max)){
            isBST = false;
        }
        if(rightData != null && (!rightData.isBST || root.data < leftData.min )){
            isBST = false;
        }
        return new ReturnType(min,max,isBST);
    }

}
