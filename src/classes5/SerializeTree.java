package classes5;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {
    public String serialize(TreeNode root) {
        if(root == null) return "#_";
        String res = root.data + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("_");
        Queue<String> q = new LinkedList<>();
        for(String node:values){
            q.add(node);
        }
        return process(q);
    }
    public TreeNode process(Queue<String> q){
        String val = q.poll();
        if(val.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(val));
        head.left = process(q);
        head.right = process(q);
        return head;
    }
}
