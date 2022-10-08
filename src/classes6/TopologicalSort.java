package classes6;

import java.util.*;

public class TopologicalSort {
    public List<Node> sortedTopology(Graph graph){
        //key:某一个node  value：剩余入度
        HashMap<Node,Integer> inMap=new HashMap<>();
        //入度为0的点才能进此队列
        Queue<Node> zeroInQueue=new LinkedList<>();
        for(Node node:graph.nodes.values()){//values()
            inMap.put(node,node.in);
            if(node.in==0){
                zeroInQueue.add(node);
            }
        }
        List<Node> res=new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            Node cur=zeroInQueue.poll();
            res.add(cur);
            for(Node next:cur.nexts){
                inMap.put(next,inMap.get(next)-1);//update
                if(inMap.get(next)==0){
                    zeroInQueue.add(next);
                }
            }
        }
        return res;
    }

}
