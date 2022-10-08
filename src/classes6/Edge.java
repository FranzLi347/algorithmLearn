package classes6;

//无向边是特殊的有向边：双向
public class Edge{
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight,Node from,Node to){
        this.weight=weight;
        this.from=from;
        this.to=to;
    }
}