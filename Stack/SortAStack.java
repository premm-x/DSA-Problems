// solution - 3

// iterative --- tc: O(n²) sc: O(n)(recursion)
 public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> tmpStack = new Stack<>();

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            
            while (!tmpStack.isEmpty() && tmpStack.peek() > curr) {
                stack.push(tmpStack.pop());
            }
            tmpStack.push(curr);
        }

        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }

        return stack;
    }

//------------------------- ( 2 ) -----------------------------
// recursion + stack --- tc: O(n²) sc: O(n)
class Solution {
    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty()) return;
        
        int top = st.pop();
        sortStack(st);
        
        if(st.isEmpty()) {
            st.push(top);
            return;
        }
        
        Stack<Integer> restore = new Stack<>();
        
        while(!st.isEmpty() && st.peek() > top){
            restore.push(st.pop());
        }
        st.push(top);
        
        while(!restore.isEmpty()){
            st.push(restore.pop());
        }
        
    }
}

//------------------------ ( 3 ) -------------------------
// recursive without extra stack --- tc: O(n²) sc: O(n)
class Solution {
    static void insertSorted(Stack<Integer> stack, int element) {
        
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
    }
    
    public void sortStack(Stack<Integer> st) {
        
        if(st.isEmpty()) return;
        
        int top = st.pop();
        sortStack(st);
        
        insertSorted(st, top);
    }
}
