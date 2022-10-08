package classes6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySets {
    public HashMap<Node, List<Node>> setMap;

    public MySets(List<Node> nodes){
        for(Node cur:nodes){
            List<Node> set=new ArrayList<>();
            set.add(cur);
            setMap.put(cur,set);
        }
    }

    //判断两个点是否在同一个集合
    public boolean isSameSet(Node from,Node to){
        List<Node> fromSet=setMap.get(from);
        List<Node> toSet=setMap.get(to);
        return fromSet==toSet;
    }

    //合并两个集合
    public void union(Node from,Node to){
        List<Node> fromSet=setMap.get(from);
        List<Node> toSet=setMap.get(to);
        for(Node toNode:toSet){
            fromSet.add(toNode);
            setMap.put(toNode,fromSet);
        }
    }
}
