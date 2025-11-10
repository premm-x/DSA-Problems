// solution - 1

// two deque --- tc: O(1) sc: O(n)
class SpecialQueue {
    
    Queue<Integer> q;
    Deque<Integer> min;
    Deque<Integer> max;

    public SpecialQueue() {
        q = new ArrayDeque<>();
        min = new ArrayDeque<>();
        max = new ArrayDeque<>();
    }

    public void enqueue(int x) {
        q.offer(x);
        
        while( !min.isEmpty() && x < min.peekLast()) min.pollLast();
        while( !max.isEmpty() && x > max.peekLast()) max.pollLast();
        
        min.offerLast(x);
        max.offerLast(x);
    }

    public void dequeue() {
        if(q.isEmpty()) return;
        
        int val = q.poll();
        
        if(!min.isEmpty() && val == min.peekFirst()) min.pollFirst();
        if(!max.isEmpty() && val == max.peekFirst()) max.pollFirst();
    } 

    public int getFront() {
        if(q.isEmpty()) return -1;
        return q.peek();
    }

    public int getMin() {
        if(min.isEmpty()) return -1;
        return min.peekFirst();
    }

    public int getMax() {
        if(max.isEmpty()) return -1;
        return max.peekFirst();
    }
}
