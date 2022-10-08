package classes6;

import java.util.*;

/*
    利用栈实现
    从源节点开始把节点按照深度放入栈，然后弹出
    每弹出一个点，把该节点的下一个没进过栈的邻接点放入栈
    直到栈变空
 */
public class MapDfs {
    public static Map<Integer, List<Integer>> graphics = new HashMap<>();

    public static void dfs(Map<Integer, List<Integer>> graphics,Integer node){
        if (node == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node);
        while(!stack.isEmpty()){
            Integer n = stack.pop();
            List<Integer> nodes = graphics.get(n);
            for (Integer i : nodes) {
                if(!set.contains(i)){
                    stack.push(i);
                    stack.push(n);
                    set.add(i);
                    System.out.println(i);
                    break;
                }
            }
        }
    }

}
