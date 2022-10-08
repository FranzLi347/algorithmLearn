package classes6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
    适用范围：没有权值为负数的边，准确说是没有出现累加和为负数的环
    规定一个出发点，这个点到其他所有点的最短距离是多少
    从该点出发，到其他点的距离，有更小的就更新，全部边都遍历结束后锁死两点之间的距离，然后在剩下的距离中选择最小的继续，所有距离都锁死之后就结束
 */
public class Dijkstra {
    public HashMap<Node,Integer> dijkstra1(Node head){
        //从head出发到所有点的最小距离，key是指从head出发到达的点，value是指head出发到key的最小距离,如果在表中没有记录则含义是head出发到这个点的距离为正无穷
        HashMap<Node,Integer> distanceMap=new HashMap<>();
        distanceMap.put(head,0);
        //已经求过距离的节点，存在selectedNodes中以后再也不碰
        HashSet<Node> selectedNodes=new HashSet<>();
        //在所有没有被求过距离的节点中选择最小的节点，如果全部节点的距离都被计算过了则返回null
        Node minNode=getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        while(minNode!=null){
            int distance=distanceMap.get(minNode);
            for(Edge edge:minNode.edges){
                if(!distanceMap.containsKey(edge.to)){
                    distanceMap.put(edge.to,distance+edge.weight);
                }else{
                    distanceMap.put(edge.to,Math.min(distanceMap.get(minNode),distance+edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode=getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);//不要忘记了这个
        }
        return distanceMap;
    }

    public Node getMinDistanceAndUnselectedNode(HashMap<Node,Integer> distanceMap, HashSet<Node> touchedNodes){
        Node minNode=null;
        int minDistance=Integer.MAX_VALUE;
        for(Map.Entry<Node,Integer> entry:distanceMap.entrySet()){
            Node node=entry.getKey();
            int distance=entry.getValue();
            if(!touchedNodes.contains(node)&&distance<minDistance){
                minNode=node;
                minDistance=distance;
            }
        }
        return minNode;
    }



/*    public HashMap<Node,Integer> dijkstra2(Node head,int size){
        NodeHeap nodeHeap=new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head,0);//黑盒
        HashMap<Node,Integer> res=new HashMap<>();
        while(!nodeHeap.isEmpty()){
            NodeRecord record=nodeHeap.pop();
            Node cur=record.node;
            int distance=record.distance;
            for(Edge edge:cur.edges){
                nodeHeap.addOrUpdateOrIgnore(edge.to,edge.weight+distance);
            }
            res.put(cur,distance);
        }
        return res;
    }

    //自行实现堆结构
    public class NodeHeap{
        private Node[] nodes;//底层数组
        private HashMap<Node,Integer> heapIndexMap;//value是索引值，作用：查node是否在堆中
        private HashMap<Node,Integer> distanceMap;//value是距离
        private int size;

        public NodeHeap(int size){
            nodes=new Node[size];
            heapIndexMap=new HashMap<>();
            distanceMap=new HashMap<>();
            size=0;//注意这个操作  复用变量
        }

        public boolean isEmpty(){
            return size==0;
        }

        //node是否进过堆  如果node进来过且被弹出来 heapIndexMap中node节点对应的value值是-1
        public boolean isEntered(Node node){
            return heapIndexMap.containsKey(node);
        }

        //判断节点是否在堆中 即进来过且没弹出
        public boolean inHeap(Node node){
            return inEntered(node)&&heapIndexMap.get(node)!=-1;
        }

        //这里的交换操作需要在两个地方进行交换：数组以及索引值
        public void swap(int index1,int index2){
            heapIndexMap.put(nodes[index1],index2);
            heapIndexMap.put(nodes[index2],index1);
            Node tmp=nodes[index1];
            nodes[index1]=nodes[index2];
            nodes[index2]=tmp;
        }

        //小根堆 向上
        public void insertHeapify(Node node,int index){
            while(distanceMap.get(nodes[index])<distanceMap.get(nodes[(index-1)/2])){
                swap(index,(index-1)/2);
                index=(index-1)/2;
            }
        }

        //小根堆 向下
        public void heapify(int index,int size){
            int left=2*index+1;
            while(left<size){
                int smallest=left+1<size&&distanceMap.get(nodes[left+1])<distanceMap.get(nodes[left]):left+1?left;
                smallest=distanceMap.get(nodes[smallest])<distanceMap.get(nodes[index])?smallest?index;
                if(smallest==index){
                    break;
                }
                swap(smallest,index);
                index=smallest;
                left=index*2+1;//不要忘记了
            }
        }

        public void addOrUpdateOrIgnore(Node node,int distance){
            if(inHeap(node)){//在堆里的情况
                distanceMap.put(node,Math.min(distanceMap.get(node),distance));
                //只可能变小了
                insertHeapify(node,heapIndexMap.get(node));
            }
            if(!isEntered(node)){
                nodes[size]=node;
                heapIndexMap.put(node,size);//索引
                distanceMap.put(node,distance);//距离
                insertHeapify(node,size++);//向上  这里的索引值可能会在swap中改变
            }
            //剩下一种情况进来过但弹出去了 就Ignore
        }

        //弹出
        public NodeRecord pop(){
            NodeRecord nodeRecord=new NodeRecord(nodes[0],distanceMap.get(nodes[0]));
            swap(0,size-1);
            heapIndexMap.put(node[size-1],-1);//两个map处理方式不同
            distanceMap.remove(nodes[size-1]);
            nodes[size-1]=null;//gc
            heapify(0,--size);//x
            return nodeRecord;
        }
    }

    public class NodeRecord{
        public Node node;
        public int distance;

        public NodeRecord(Node node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }*/

}
