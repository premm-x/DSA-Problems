// solution - 1

// brute logic --- tc: Worst-case O(n), amortized O(1). sc: O(n)
class RecentCounter {

    Queue<Integer> q;

    public RecentCounter() {
        q = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        
        while( !q.isEmpty() && (t - 3000) > q.peek() ){
            q.poll();
        }
        q.offer(t);

        return q.size();
    }
}

// ------------- clear code written of 1st one ---------------
// same clear one  ---  tc: Worst-case O(n), amortized O(1). sc: O(n)
class RecentCounter {

    Queue<Integer> q;
    public RecentCounter() {
        q = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        
        q.offer(t);
        while( t - 3000 > q.peek() ) q.poll();

        return q.size();
    }
}
