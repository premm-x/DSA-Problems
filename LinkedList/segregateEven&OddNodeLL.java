// solution - 1

// two pointer --- tc: O(n) sc: O(1)
class Solution {
    Node divide(Node head) {
        
        if(head == null || head.next == null) return head;
        
        Node even = null;
        Node odd = null;
        Node evenHead = null;
        Node oddHead = null;
        
        Node curr = head;
        
        while(curr != null){
            
            if( (curr.data % 2) != 0 ){
                if(odd == null) {
                    odd = curr;
                    oddHead = curr;
                }
                else {
                    odd.next = curr;
                    odd = odd.next;
                }
                
            }
            else{
                if(even == null) {
                    even = curr;
                    evenHead = curr;
                }
                else {
                    even.next = curr;
                    even = even.next;
                }
            }
            
            curr = curr.next;
        }
        odd.next = null;
        
        if(evenHead != null)
            even.next = oddHead;
            
        return (evenHead == null ? oddHead : evenHead);
    }
}


