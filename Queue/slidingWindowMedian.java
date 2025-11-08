// solution - 1

// List(window) binarySearch  --- tc: O(n*k) sc: O(n)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        int n = nums.length, j = 0;
        double ans[] = new double[n - (k-1)];
        List<Integer> window = new ArrayList<>();

        for(int i=0; i<n; i++){
            
            int indx = Collections.binarySearch(window, nums[i]);
            if(indx < 0) indx = -indx - 1;
            window.add(indx, nums[i]);

            if(i >= k){
                int posEle = Collections.binarySearch(window, nums[i-k]);
                window.remove(posEle);
            }

            if(i >= k-1){
                if(k%2 == 1) ans[j++] = window.get(k/2);
                else ans[j++] = ( (double) window.get(k/2 - 1) + window.get(k/2)) / 2.0;
            }
        }
        return ans;
    }
}

