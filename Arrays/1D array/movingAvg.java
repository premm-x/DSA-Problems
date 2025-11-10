// solution - 1

// simple logic --- tc: O(n) sc: O(1);
public int[] movingAvg(int[] nums){
  
    float[] ans = new float[nums.length];
    int l = 0, sum = 0;
        
    for(int i=0; i<nums.length; i++){

        sum += nums[i];

        if(i >= k) sum -= nums[l++];
            
        float a = (float)sum/k;

        ans[i] = Math.round(a * 100f) / 100f;
    }
    return ans;
}
