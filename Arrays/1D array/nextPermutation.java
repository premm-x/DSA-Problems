// brute --- pivot --- O(n + nlgon)

class Solution {

    void swap(int[] nums, int a, int b){

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public void nextPermutation(int[] nums) {
        
        int n = nums.length, pivot = -1;
        boolean next = false;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                next = true;
                break;
            }
        }

        if (next) {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[pivot]) {
                    swap(nums, i, pivot);
                    break;
                }
            }

            Arrays.sort(nums, pivot + 1, n);
        }
        else{
            Arrays.sort(nums);
        }

    }
}


