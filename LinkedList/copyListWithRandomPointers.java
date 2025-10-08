// solution - 1

// hashing --- tc: O(2n * logn) sc: O(n)
class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) return head;
        
        HashMap<Node, Node> map = new HashMap<>();
        
        Node newhead = new Node(head.val);
        map.put(head, newhead);
        Node oldNode = head.next;
        Node tempNode = newhead;

        while(oldNode != null){
            Node newNode = new Node(oldNode.val);
            map.put(oldNode, newNode);
            tempNode.next = newNode;
            oldNode = oldNode.next;
            tempNode = tempNode.next;
        }
        
        oldNode = head;
        tempNode = newhead;

        while(oldNode != null){
            tempNode.random = map.get(oldNode.random);
            oldNode = oldNode.next;
            tempNode = tempNode.next;
        }

        return newhead;
    }
}
