// solution - 1

// ralaxation ( of bellman fors algo used to detect neg cycle ) --- tc: O(v*e) sc: O(n)
class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        
        int[] dist = new int[n];
        
        for(int i=0; i <= n; i++){
            for(int[] e : edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                
                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    
                    if(i == n) return 1;
                }
            }
        }
        return 0;
    }
}
