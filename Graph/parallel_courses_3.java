// solution - 1
// ( another name ) Minimum time to complete tasks

// toposort + dp  --- tc: O(N+M) sc: O(N+M)
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n+1; i++) adj.add(new ArrayList<>());
        
        int[] indegree = new int[n+1];
        
        for(int[] e : relations){
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] dp = new int[n+1];

        for(int i=1; i<indegree.length; i++){
            if(indegree[i] == 0) q.add(i);
            dp[i] = time[i-1];
        }

        while(!q.isEmpty()){
            int u = q.poll();

            for(int v : adj.get(u)){
                dp[v] = Math.max(dp[v], dp[u] + time[v-1]);

                indegree[v]--;
                if(indegree[v] == 0) q.add(v);
            }
        }

        int ans = 0;
        for(int m : dp) ans = Math.max(ans, m);

        return ans;
    }
}


