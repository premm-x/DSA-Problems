//solution - 2

// recursion --- tc: O(n) sc: (recursive stack only)
class Solution {
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode nxt =  head.next;
        head.next = swapPairs(head.next.next);
        nxt.next = head;
        return nxt;
    }
}

//-------------------------- ( 2 ) -----------------------------
// iterative --- tc: O(n) sc: O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, cur = head;

        while (cur != null && cur.next != null) {
            ListNode npn = cur.next.next;
            ListNode second = cur.next;

            second.next = cur;
            cur.next = npn;
            prev.next = second;

            prev = cur;
            cur = npn;
        }

        return dummy.next;        
    }
}
