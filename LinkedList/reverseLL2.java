// solution - 2
// brute --- O(n) --- without dummy

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
      
        ListNode st = head;
        int counter = 1;

        ListNode conn = null;
        while( head != null && counter < left){
            conn = head;
            head = head.next;
            counter++;
        }
        ListNode tail = head;

        ListNode prev = null;
        while(head != null && counter <= right){
            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
            counter++;
        }

        if(conn != null){
            conn.next = prev;
        }else{
            st = prev;
        }
        tail.next = head;

        return st;
    }
}

// ------------------ 2 ---------------------
// easy to read --- O(n) --- with dummy

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i=1; i < left; i++) prev = prev.next;

        ListNode curr = prev.next;
        ListNode pre = null;

        for(int i=left; i<=right; i++){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        prev.next.next = curr;
        prev.next = pre;
              
        return dummy.next;
    }
}
