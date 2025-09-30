// recursive --- O(n)
class Solution {
    ListNode helper(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode NewHead = helper(head.next);

        head.next.next = head;
        head.next = null;
        return NewHead;
    } 

    public ListNode reverseList(ListNode head) {
        return helper(head);
    }
}

// iterative --- O(n)

class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
             
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
