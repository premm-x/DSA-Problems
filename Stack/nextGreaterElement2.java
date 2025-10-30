// solution - 1

// stack approch --- tc: O(n) sc: O(n)
class Solution {
    public int[] nextGreaterElements(int[] arr) {
        
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);

        for(int i = 0; i < arr.length * 2; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i % arr.length]){
                ans[st.pop()] = arr[i % arr.length];
            }
            if(i < arr.length) st.push(i % arr.length);
        }
        return ans;
    }
}
