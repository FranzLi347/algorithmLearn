package classes6;

import java.util.*;
/*
    利用队列实现
    从源节点开始依次按照宽度进队列，然后弹出
    每弹出一个点，把该节点所有没进过队列的邻接点放入队列
    直到队列变空
 */
public class MapBfs {

    // 邻接表 表示 图
    public static Map<Integer, List<Integer>> graphics = new HashMap<>();


    // from node bfs
    public static void bfs(Map<Integer, List<Integer>> graphics,Integer node){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            Integer n = queue.poll();
            System.out.println(n);
            List<Integer> nodes = graphics.get(n);
            for (Integer i : nodes) {
                if(!set.contains(i)){
                    queue.add(i);
                    set.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        graphics.put(1,List.of(2,3,4));
        graphics.put(2,List.of(1,5));
        graphics.put(3,List.of(1,5));
        graphics.put(4,List.of(1,5));
        graphics.put(5,List.of(2,3,4));
        bfs(graphics,1);
    }


}
