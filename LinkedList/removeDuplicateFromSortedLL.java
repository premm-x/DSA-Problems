//solution - 1

// O(n)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null) return head;
        ListNode st = head;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                head.next = head.next.next;
            }
            else
                head = head.next;
        }
        return st;        
    }
}
