// solution - 3    --- currently stack solution is not available

// brute force --- tc: O(n²) sc: O(1)
class Solution {
    public int trap(int[] h) {
        int n = h.length, sum = 0;
        
        for(int i=0; i<n; i++){
            int lmax = 0, rmax = 0;
            
            for(int j=i; j>=0; j--){
                lmax = Math.max(h[j], lmax);
            }

            for(int j=i; j<n; j++){
                rmax = Math.max(h[j], rmax);
            }
            
            int minHeight = Math.min(lmax, rmax);
            sum += minHeight - h[i];
        }
        return sum;
    }
}

// better (prefix sum) --- tc: O(n) sc: O(n)
class Solution {
    public int trap(int[] h) {
        int n = h.length, sum = 0;

        int lmax[] = new int[n];
        int rmax[] = new int[n];

        lmax[0] = h[0];
        rmax[n-1] = h[n-1];

        for(int j=1; j<n; j++){
            lmax[j] = Math.max(h[j], lmax[j-1]);
        }

        for(int j=n-2; j>=0; j--){
            rmax[j] = Math.max(h[j], rmax[j+1]);
        }

        for(int i=0; i<n; i++){
            int minHeight = Math.min(lmax[i], rmax[i]);
            sum += minHeight - h[i];
        }

        return sum;
    }
}

// optimal (two pointer) --- tc: O(n) sc: O(1)
class Solution {
    public int trap(int[] h) {
        int n = h.length, sum = 0 , l = 0, r = n-1;

        int lmax = 0;
        int rmax = 0;

        while(l < r){
            
            lmax = Math.max(lmax, h[l]);
            rmax = Math.max(rmax, h[r]);

            if(lmax < rmax){
                sum += lmax - h[l];
                l++;
            }
            else{
                sum += rmax - h[r];
                r--;
            }
        }
        return sum;
    }
}

