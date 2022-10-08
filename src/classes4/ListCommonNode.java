package classes4;

/*
    输入两个链表，找出它们的第一个公共节点。
 */

public class ListCommonNode {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len = 0;
        ListNode p1 = headA,p2 = headB;
        while(p1 != null){
            p1 = p1.next;
            len ++;
        }
        while(p2 != null){
            p2 = p2.next;
            len --;
        }
        p1 = len > 0 ? headA : headB;
        p2 = p1 == headA ? headB : headA;
        len = Math.abs(len);
        while(len-- != 0){
            p1 = p1.next;
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
