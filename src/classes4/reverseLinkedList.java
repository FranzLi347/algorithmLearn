package classes4;

public class reverseLinkedList {public ListNode reverseList(ListNode head) {
    if(head == null) return head;
    ListNode pre = null,p = head;
    while(p.next != null){
        ListNode t = p; // 1
        ListNode pnext = p.next; // 2
        p.next = pre; // 2 -> 1
        pre = p; // pre = 1
        p = pnext; //
    }
    p.next = pre;
    return p;
    }
}
