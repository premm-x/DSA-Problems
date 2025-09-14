// 1. brute --- for loop --- O(n) 
// 2. optimal --- binary search --- O(log n)
// ( also done in recursion )
public int search(int[] arr, int trg) {
        
        int st = 0, end = arr.length-1;

        while(st <= end){
            
            int mid = st + (end - st)/2;

            if(arr[mid] == trg) return mid;

            else if(arr[st] <= arr[mid]){
                if(arr[st] <= trg && trg < arr[mid] ) end = mid-1;
                else st = mid+1;
            }

            else {
                if(arr[mid] <= trg && trg <= arr[end] ) st = mid+1;
                else end = mid-1;
            }

        }
        return -1;
    }


