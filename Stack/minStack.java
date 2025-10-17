// solution - 1
// stack --- tc: O(1) for all operation,  sc: O(n)
class MinStack {
    Stack<Integer> st;
    Stack<Integer> stmin = new Stack<>();   
    public MinStack() {
        st = new Stack<>();    
    }
    public void push(int val) {
        
        if(stmin.isEmpty() || val <= stmin.peek()) stmin.push(val);
        
        st.push(val);
    }
    public void pop() {
        Integer val = st.pop();
        if(val.equals(stmin.peek())) stmin.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return stmin.peek();
    }
}
