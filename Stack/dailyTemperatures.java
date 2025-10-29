// solution - 2
// brute force approch --- tc: O(n) sc: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        Stack<int[]> st = new Stack<>();
        int ans[] = new int[temp.length];

        for(int i=temp.length-1; i>=0; i--){
            int sum = 0;

            if(!st.isEmpty() && temp[i] < st.peek()[0]){
                ans[i] = 1;
                st.push(new int[]{temp[i], 1});
                continue;
            }
            while(!st.isEmpty() && temp[i] >= st.peek()[0]){
                sum += st.pop()[1];
            }
            if(st.isEmpty()){
                ans[i] = 0;
                st.push(new int[]{temp[i], 0});
            }
            else{
                sum += 1;
                ans[i] = sum;
                st.push(new int[]{temp[i], sum});
            }
        }
        return ans;
    }
}
// ---------------------------------- ( 2 ) ------------------------------------
// my version code easy to understand --- tc: O(n) sc: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[temp.length];

        for(int i=0; i<temp.length-1; i++){
            if(temp[i] < temp[i+1]){
                ans[i] = 1;

                while(!st.isEmpty() && temp[st.peek()] < temp[i+1]){
                    ans[st.peek()] = (i+1) - st.pop();
                }
            }
            else st.push(i);
        }
        return ans;
    }
}
// ----------------------------------- ( same 2 approch ) -----------------------------------
// more cleaner way to write
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[temp.length];

        for(int i=0; i<temp.length; i++){
            while(!st.isEmpty() && temp[st.peek()] < temp[i]){
                ans[st.peek()] = (i) - st.pop();
            }
            st.push(i); 
        }
        return ans;
    }
}
