package classes6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
从点出发（任意一个点），然后解锁该点相关的所有边，在所有边中选取最小的，然后把该边连接的另外一个点加上，
再解锁所有边，依次循环，直到所有点都加进来了，在这个过程中，如果一条边的两个点都已经加入过，则该边不在选择范围内
 */

public class Prim {
    public Set<Edge> primMST(Graph graph){
        //小根堆
        PriorityQueue<Edge> priorityQueue=new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        //放点
        HashSet<Node> set=new HashSet<>();
        //放边（结果）
        Set<Edge> res=new HashSet<>();

        for(Node node:graph.nodes.values()){//这层for循环是为了解决森林问题 如果没有该问题可以省去（即整个图没有互相连在一起）
            if(!set.contains(node)){
                set.add(node);
                for(Edge edge:node.edges){
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()){
                    Edge edge=priorityQueue.poll();
                    Node toNode=edge.to;
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        res.add(edge);
                        for(Edge nextEdge:toNode.edges){
                            priorityQueue.add(nextEdge);//这里边可能会重复加进集合 但不影响结果 增加的是常数时间 如果想优化该部分 可以再加一层判断
                        }
                    }
                }
            }
        }
        return res;
    }
}
