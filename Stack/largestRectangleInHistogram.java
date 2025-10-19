// solution - 2

// brute force --- tc: O() sc:O() --- **TLE** 
// --- not submitted because large input but logic in correct work for small input under 10⁴
class Solution {
    public int largestRectangleArea(int[] h) {

        int largest = 0;
        
        for(int i=0; i<h.length; i++){
            int w = 1;
            
            for(int j=0; j<h.length; j++){
                if(i > j && h[i] > h[j]) {
                    w = 1;
                    continue;
                }
                if(i == j) continue;
                if(h[i] > h[j]) break;
                w++;

            }
            int area = h[i]*w;
            largest = Math.max(largest, area);
        }
        return largest;
    }
}

// --------------------------- ( 2 ) -----------------------------
// optimized (next greater/ smaller problem approch) --- tc: O(n) sc: O(n)

class Solution {
    public int largestRectangleArea(int[] h) {

        Stack<Integer> st = new Stack<>();
        int[] nextSm = new int[h.length];
        int[] prevSm = new int[h.length];

        for(int i=h.length-1; i>=0; i--){
            
            while(!st.isEmpty() && h[i] <= h[st.peek()]){
                st.pop();
            }   
            nextSm[i] = st.isEmpty() ? h.length : st.peek();
            st.push(i);
        }

        st = new Stack<>();
        
        for(int i=0; i<h.length; i++){
            
            while(!st.isEmpty() && h[i] <= h[st.peek()]){
                st.pop();
            }
            prevSm[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int largest = Integer.MIN_VALUE;
        for(int i=0; i<nextSm.length; i++){
            int area = ( (nextSm[i] - prevSm[i]) - 1) * h[i] ;
            largest = Math.max(largest, area);
        }
        
        return largest;
    }
}
