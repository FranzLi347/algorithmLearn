package classes4;

/*

给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
复制链表中的指针都不应指向原链表中的节点

 */



public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }


    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node p = head;
        while(p != null){ // 1 -> 2 -> 3     1 -> 1(copy) -> 2 -> 2(copy) -> 3 -> 3(copy)
            Node t = new Node(p.val);
            t.next = p.next;
            p.next = t;
            p = t.next;
        }
        p = head;
        while(p != null){ // connect random point
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }

        p = head;
        Node res = p.next;
        Node curcp = null;
        Node next = null;
        while(p != null){
            next = p.next.next;
            curcp = p.next;
            p.next = next;
            curcp.next = next != null ? next.next : null;
            p = next;
        }
        return res;
    }
}
