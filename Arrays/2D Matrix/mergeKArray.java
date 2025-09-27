// Brute --- tc O(n² log n) - sc O(n) --- Queue

public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                q.offer(arr[i][j]);
            }
        }
        while(!q.isEmpty()) ans.add(q.poll());
        
        return ans;
    }

//-----------------------------------------------------
