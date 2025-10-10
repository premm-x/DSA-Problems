// solution - 1

// slow and fast pointer --- tc: O(n) sc: O(1)
class Solution {
    
    public Pair<Node, Node> splitList(Node head) {
        
        if(head == null || head.next == head) return new Pair<>(head, head);
        
        Node start = head, fast = head;
        
        while( fast.next != head && fast.next.next != head ){
            start = start.next;
            fast = fast.next.next;
        }
        
        if(fast.next == head) fast.next = start.next;
        else fast.next.next = start.next;
         
        Node head2 = start.next;
        start.next = head;
        
        
        return new Pair<>( head, head2 );
    }
}
