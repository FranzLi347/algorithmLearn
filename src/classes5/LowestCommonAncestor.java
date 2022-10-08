package classes5;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {

    /*
        情况可以分为两大类

        1.node1是node2的最低公共祖先或者node2是node1的最低公共祖先

        2.node1与node2通过汇聚才能找到最低公共祖先

        一个子树上如果没有node1也没有node2则返回空

        有node1则返回node1，有node2则返回node2

        一个子树上的左右子树都有返回值则返回当前节点

     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){ // base case
            return root; // 如果找到null 或者p 或者q则返回
        }
        TreeNode leftNode = lowestCommonAncestor1(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor1(root.right,p,q);
        if(leftNode != null && rightNode != null){
            return root;
        }
        return leftNode == null ? rightNode : leftNode;
    }


    // use map version
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> hashmap=new HashMap<>();
        hashmap.put(root,root);
        HashSet<TreeNode> hashset=new HashSet<>();
        hashset.add(root);
        process(root,hashmap);
        while(p!=hashmap.get(p)){//注意退出while的条件
            hashset.add(p);
            p=hashmap.get(p);
        }
        while(q!=hashmap.get(q)){
            if(hashset.contains(q)){
                break;
            }else{
                q=hashmap.get(q);
            }
        }
        return q;
    }

    public void process(TreeNode node, HashMap hashmap){
        if(node==null){
            return;
        }
        if(node.left!=null){
            hashmap.put(node.left,node);
        }
        if(node.right!=null){
            hashmap.put(node.right,node);
        }
        process(node.left,hashmap);
        process(node.right,hashmap);
    }
}
