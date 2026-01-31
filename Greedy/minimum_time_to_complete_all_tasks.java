// solution - 1

//using array with greedy --- tc: O(n*time duration)  sc: O(n)
class Solution {
    public int findMinimumTime(int[][] tasks) {

        Arrays.sort(tasks, (a,b) -> a[1] - b[1]);

        int[] arr = new int[2001];

        int i=0; 

        while(i < tasks.length){
            int start =  tasks[i][0];
            int end = tasks[i][1];
            int time = tasks[i][2];

            for(int j=start; j<=end; j++){
                if(arr[j] != 0) time--;
            }

            while(time > 0){
                if(arr[end] != 0) {
                    end--;
                    continue;
                }

                arr[end--]++;
                time--;
            }

            i++;
        }

        int ans = 0;
        for(int j : arr){
            if(j != 0) ans++;
        }

        return ans;
    }
}

