// solution - 1

// recursion --- tc: O(n) sc: O(n)
class Solution {
    void helper(Queue<Integer> q){
        if(q.isEmpty()) return;
            
        int a = q.poll();
        helper(q);
        q.offer(a);
    }
    public void reverseQueue(Queue<Integer> q) {
        helper(q); 
    }
}
