// solution - 1
// slow-fast --- O(n)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode s = head, f = head;

        for(int i=0; i<n; i++) f = f.next;

        if(f == null) return head.next;

        while(f.next != null){
            s = s.next;
            f = f.next;
        }
        s.next = s.next.next;
        
        return head;
    }
}
