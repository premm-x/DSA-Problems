// solution - 1

// two queue approch represnt stack --- tc: O(n²) sc: O(n)
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(arr.length, -1));
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i=0; i<arr.length; i++){
            
            while(!q1.isEmpty() && arr[q1.peek()] < arr[i] ){
                ans.set(q1.poll(), arr[i]);
            }
            
            if(q1.isEmpty()) q1.offer(i);
            else{
                while(!q1.isEmpty()){
                    q2.offer(q1.poll());
                }
                q1.offer(i);
                while(!q2.isEmpty()){
                    q1.offer(q2.poll());
                }
            }
        }
        
        return ans;
    }
}

