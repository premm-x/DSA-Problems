//1. brute --- O(n²) --- two forLoop
//2. optimal --- O(2n) - sc O(n) (sc because using **array**);

//3. optimal --- O(2n) - sc O(1) --- prefix + suffix
public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];

        ans[0] = 1;
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int suffix = 1;
        for(int i=nums.length-2; i>= 0; i--){
            suffix *= nums[i+1];
            ans[i] = ans[i] * suffix;
        }

        return ans;
}

//----------------------------------------------------------
//                       custom
//----------------------------------------------------------

public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        int fp = 0, sp = 0, mul = 1;
        
        while (fp < nums.length) {
            if(fp != sp){
                mul *= nums[sp];
                sp++;
            }
            else{
                sp++;
            }

            if(sp >= nums.length){
                ans[fp] = mul;
                mul = 1;
                sp = 0;
                fp++;
            } 
        }
        return ans;
    }
//-----------------------------------------
