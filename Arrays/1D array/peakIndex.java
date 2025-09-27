// there is two type with -infinit or without it

// ---------------------------------with -infinit-----( 2 approch )------------------------------
// 1. brute my way --- O(log n)
public int findPeakElement(int[] arr) {

        if(arr.length == 1 || arr[0] > arr[1]) return 0;
        if(arr.length > 1 && arr[arr.length-1] > arr[arr.length-2]) return arr.length-1;
        
        int st = 1, end = arr.length-2;

        while(st <= end){

            int mid = st + (end - st)/2;

            if(arr[mid-1] < arr[mid] && arr[mid+1] < arr[mid]){
                return mid;
            }
            else if(arr[mid-1] > arr[mid]){
                end = mid-1;
            }
            else st = mid+1;
             
        }
        return -1;
    }

// 2. cleaner code optimal (approch 2) --- O(log n)
if(arr.length == 1) return 0;

        int st = 0, end = arr.length-1;

        while(st < end){

            int mid = st + (end - st)/2;

            if(arr[mid] > arr[mid+1]){
                end = mid;
            }
            else{
                st = mid + 1;
            }
        }
      return st;

//------------------------------------------------------------------------------
//-----------------------------------without -infinit-------------------------------------------
// 1. brute --- for loop --- O(n)
// 2. optimal --- O(log n)
public int peakIndexInMountainArray(int[] arr) {
        
        int st = 1, end = arr.length-2;

        while(st <= end){
            
            int mid = st + (end-st)/2;

            if(arr[mid-1] < arr[mid] && arr[mid+1] <arr[mid] ){
                return mid;
            }
            else if(arr[mid-1] > arr[mid]){
                end = mid-1;
            }
            else{
                st = mid + 1;
            }
        }
        return -1;
    }



//----------------------------------------------------------------------------------



