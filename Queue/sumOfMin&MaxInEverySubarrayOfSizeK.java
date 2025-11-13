// solution - 1

// Deque based approch optimal --- tc: O(n) sc: O(n)
class Solution {
    public int maxOfSubarrays(int[] arr, int k) {

        int sum = 0;
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();

        for(int i=0; i<arr.length; i++){
            // maintain window size
            while(!min.isEmpty() && min.peekFirst() <= i - k ) min.pollFirst();
            while(!max.isEmpty() && max.peekFirst() <= i - k ) max.pollFirst();
            // maintain dequeu min & max
            while(!min.isEmpty() && arr[min.peekLast()] >= arr[i]) min.pollLast();
            while(!max.isEmpty() && arr[max.peekLast()] <= arr[i]) max.pollLast();

            min.add(i);
            max.add(i);
            
            if(i >= k-1)
                sum += arr[min.peekFirst()] + arr[max.peekFirst()];
        }
        return sum;
    }
}
