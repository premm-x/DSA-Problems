// solution - 2

// HashMap/HashSet --- tc: O(n) - sc: O(n)

class Solution {
    public Node removeDuplicates(Node head) {
        
        HashMap<Integer, Node> map = new HashMap<>();
        Node st = head;
        Node prev = null;
        
        while(head != null){
            
            if(!map.containsKey(head.data)){
                map.put(head.data, head);
                prev = head;
            }
            else{
                prev.next = head.next;
            }
            head = head.next;
        }
        return st;
    }
}

// ---------------------------- ( 2 ) --------------------------------
// brute froce --- tc: O(n²) sc: O(1)

class Solution {
    public Node removeDuplicates(Node head) {
        Node curr = head;
        
        while(curr != null){
            Node runner = curr;
            while(runner.next != null){
                if(curr.data == runner.next.data){
                    runner.next = runner.next.next;
                }
                else
                    runner = runner.next;
            }
            curr = curr.next;
        }
        return head;
    }
}


