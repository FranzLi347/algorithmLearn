package classes5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeMaxWidth {

    public static int maxWidthUseMap(TreeNode head){
        if(head == null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode,Integer> map = new HashMap<>();
        queue.add(head);
        map.put(head,1);
        int max = Integer.MIN_VALUE;
        int curLevel = 1;
        int curLevelNode = 0;
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            // 结算
            if(map.get(curNode) != curLevel){
                max = Math.max(max,curLevelNode);
                curLevel ++;
                curLevelNode = 1;
            }else{
                curLevelNode ++;
            }
            if(curNode.left != null){
                queue.add(curNode.left);
                map.put(curNode.left,curLevel + 1);
            }
            if(curNode.right != null){
                queue.add(curNode.right);
                map.put(curNode.right,curLevel + 1);
            }
        }
        return max;
    }

    public static int maxWidthNoUseMap(TreeNode head){
        if(head == null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curEnd = head;
        TreeNode nextEnd = null;
        queue.add(head);
        int curLevelNodes = 0;
        int max = 0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left != null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes ++;
            if(cur.equals(curEnd)){
                max = Math.max(curLevelNodes,max);
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return max;
    }
}
