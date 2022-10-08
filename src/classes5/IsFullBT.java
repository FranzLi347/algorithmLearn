package classes5;

/*
如何判断一棵树是完全二叉树
完全二叉树：堆：只有最后一层可能不是满的，即使最后一层不满，也是从左往右是满的
宽度优先遍历
两个条件返回false
1.任一节点有右节点没有左节点
2.在1的条件下，如果遇到了第一个左右孩子不全的情况，后续节点都应该为叶子节点——》需设置触发器
 */


import java.util.LinkedList;
import java.util.Queue;

public class IsFullBT {
    public static boolean isFullBt(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isFirstM = true;
        while (!queue.isEmpty()){
            TreeNode t = queue.poll();
            if(t.left != null) queue.add(t.left);
            if(t.right != null) queue.add(t.right);
            if(t.left == null && t.right != null) return false;
            if(t.left == null || t.right == null) {
                if(isFirstM) {
                    isFirstM = false;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
