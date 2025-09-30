//solution - 1

/*
1. slow-fast --- Time: O(n) Space: O(1)  --- Floyd’s Cycle Detection (Tortoise & Hare) – Optimal
2. Hashing (Visited Nodes) Keep a HashSet of visited nodes. If a node repeats → cycle exists. --- Time: O(n) Space: O(n)
*/

//1.  slow-fast --- O(n) --- Floyd’s Cycle Detection (Tortoise & Hare) – Optimal
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) return true;
        }
        return false;
    }
}

//2.  Hashing (Visited Nodes) --- Time: O(n) Space: O(n)
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        HashSet<ListNode> set = new HashSet<>();

        while(head != null){
            if(!set.contains(head)){
                set.add(head);
                head = head.next;
            }
            else return true;
        }
        return false;
    }
}
