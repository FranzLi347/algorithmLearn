package classes6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
从边的角度出发，从最小的边开始，判断如果加上的话有无形成环，没有环则加上，有则不要
keypoint:怎么判断有无形成环：并查集
假设所有的点一开始自己都是一个集合
边加上之前判断边的两个点是否在一个集合中，是则不要，不是则将两个点所在的集合合并
 */
public class kruskal {
    public Set<Edge> kruskalMST(Graph graph){
        UnionFind unionFind=new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue=new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        priorityQueue.addAll(graph.edges);
        Set<Edge> res=new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge edge=priorityQueue.poll();
            if(!unionFind.isSameSet(edge.from,edge.to)){
                res.add(edge);
                unionFind.union(edge.from,edge.to);
            }
        }
        return res;
    }
}
