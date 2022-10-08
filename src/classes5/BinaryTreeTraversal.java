package classes5;



/*
    二叉树非递归遍历
 */
import java.util.Stack;

public class BinaryTreeTraversal {

    public static void preOrderTraversal(TreeNode head){
        if(head != null){
            Stack<TreeNode> s = new Stack<>();
            s.push(head);
            while(!s.isEmpty()){
                TreeNode cur = s.pop();
                System.out.print(cur.data + " ");
                if(cur.right != null){
                    s.push(cur.right);
                }
                if(cur.left != null){
                    s.push(cur.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderTraversal(TreeNode head){
        if(head != null){
            Stack<TreeNode> s = new Stack<>();
            while(!s.isEmpty() || head != null){
                if(head != null){
                    s.push(head);
                    head = head.left;
                }else{
                    head = s.pop();
                    System.out.print(head.data + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void posOrderTraversal(TreeNode head){
        if(head != null){
            Stack<TreeNode> s = new Stack<>();
            Stack<TreeNode> help = new Stack<>();
            s.push(head);
            while(!s.isEmpty()){
                head = s.pop();
                help.push(head);
                if(head.left != null){
                    s.push(head.left);
                }
                if(head.right != null){
                    s.push(head.right);
                }
            }
            while(!help.isEmpty()){
                System.out.print(help.pop().data + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(6);
        head.right = new TreeNode(4);
        head.right.left = new TreeNode(7);
        head.right.right = new TreeNode(5);
        preOrderTraversal(head);
        inOrderTraversal(head);
        posOrderTraversal(head);
    }



}
