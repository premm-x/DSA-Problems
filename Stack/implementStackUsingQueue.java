// solution - 2

// using 1 queue --- tc: O(n) sc: O(n)
class MyStack {
    Queue<Integer> q = new ArrayDeque<>();
    public MyStack() {}
    public void push(int x) {
        q.add(x);
        for(int i=0; i<q.size()-1; i++){
                q.add(q.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
// --------------------------- ( 2 ) ------------------------------
// using 2 queue --- tc: O(n) sc: O(n)
class MyStack {
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();
    public MyStack() {}
    public void push(int x) {
        while(q1.size() > 0){
            q2.add(q1.poll());
        }
        q1.add(x);
        while(q2.size() > 0){
            q1.add(q2.poll());
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
