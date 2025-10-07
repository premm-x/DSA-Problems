// solution - 2

// Brute force --- tc: O(n) sc: O(n/k)(recusion only)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        int j = 0;
        while(temp != null && j < k){
            j++;
            temp = temp.next;
        }
        if(j < k) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        int i = 1;
        while(curr != null && i <= k){
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}

// ------------------------------ ( 2 ) ----------------------------------
// optimal --- tc: O(n) sc: O(1)


