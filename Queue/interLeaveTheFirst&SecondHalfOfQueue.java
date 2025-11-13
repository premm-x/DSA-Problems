// solution - 2

// brute force --- tc: O(n) sc: O(n)
class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        
        int n = q.size();
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        while(!q.isEmpty()){
            if(q.size() > n/2)
                q1.offer(q.poll());
            else
                q2.offer(q.poll());
        }
        
        for(int i=1; i<=n; i++){
            if(i % 2 == 1)
                q.offer(q1.poll());
            else
                q.offer(q2.poll());
        }
    }
}

// ------------------------------- ( 2 ) -----------------------------------
// array based answer --- tc: O(n) sc: O(n)
class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        
        int n = q.size();
        int arr[] = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = q.poll();
        }
        
        for(int i=0; i<n/2; i++){
            q.offer(arr[i]);
            q.offer(arr[(n/2)+i]);
        }
    }
}


