package classes4;


/*
判断是否回文链表 时间复杂度O(N) 空间复杂度O(1)方法
 */
public class palindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode mid = getMid(head);
        ListNode reHead = reverseList(mid.next);
        ListNode p1 = head;
        ListNode p2 = reHead;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode getMid(ListNode p){
        ListNode fast = p,slow = p;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // in middle first
        return slow;
    }
}
