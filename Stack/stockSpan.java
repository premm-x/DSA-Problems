// solution -1

// stack based --- tc: worst case: O(n) Amortized per operation: O(1) sc: O(n)
class StockSpanner {

    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int sum = 1;
        
        while(!st.isEmpty() && st.peek()[0] <= price){
            sum = sum + st.pop()[1];
        }
        st.push(new int[]{price, sum});

        return sum;
    }
}
