// solution - 1 

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
