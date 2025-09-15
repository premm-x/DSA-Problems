// 1. brute --- O(N logn)
// 2. optimal --- O(log (m+n)

//---------------------------------------------------------
// 1. brute --- O(N logn)

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int k=0;
        int arr[] = new int[nums1.length + nums2.length];

        for (int i : nums1) {
            arr[k++] = i;
        }
        for (int i : nums2) {
            arr[k++] = i;
        }
        Arrays.sort(arr);

        int n = arr.length;

        if(n%2 == 0){
            return (arr[(n/2)-1] + arr[n/2]) / 2.0;
        }
        else
            return (double) arr[n/2];

    }


// 2. optimal --- O(m+n)

public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length + nums2.length;
        int trg = (int)Math.ceil(n/2.0) , count = 0;

        int p1 = 0, p2 = 0;

        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] < nums2[p2]){
                p1++;
                count++;
                if(count == trg) {
                    if(n%2 == 0){
                        if(nums1.length - p1 == 0)
                            return (nums1[p1-1] + nums2[p2]) / 2.0;
                        else{
                            return (nums1[p1-1] + Math.min(nums1[p1], nums2[p2])) / 2.0;
                        }
                    }
                    else
                        return (double) nums1[p1-1];
                }
            }
            else{
                p2++;
                count++;
                if(count == trg) {
                    if(n%2 == 0){
                        if(nums2.length - p2 == 0)
                            return (nums2[p2-1] + nums1[p1]) / 2.0;
                        else{
                            return (nums2[p2-1] + Math.min(nums1[p1], nums2[p2])) / 2.0;
                        }
                    }
                    else
                        return (double) nums2[p2-1];
                }
            }
        }

        if(count != trg){
            if(p1 < nums1.length){
                p1 = p1 + (trg - count)-1;
                
                if(n%2 == 0){
                    return (nums1[p1] + nums1[p1+1]) / 2.0;
                }
                else
                    return (double) nums1[p1];
            }

            else{
                p2 = p2 + (trg - count)-1;

                if(n%2 == 0){
                    return (nums2[p2] + nums2[p2+1]) / 2.0;
                }
                else
                    return (double) nums2[p2];
            }
        }

        return -1;
    }





