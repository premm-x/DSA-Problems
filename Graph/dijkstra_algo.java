// solution - 1
// bfs --- tc: O(e logv) sc: O(v)
// optimised by if(d > dist[u]) continue;
class Solution {
    public int[] dijkstra(int n, int[][] edges, int src) {
        
        @SuppressWarnings("unchecked")
        ArrayList<int[]> graph[] = new ArrayList[n];
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges){
            graph[e[0]].add(new int[]{e[2], e[1]});
            graph[e[1]].add(new int[]{e[2], e[0]});
        }
        
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[0] - b[0] );
        pq.add(new int[]{0, src});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            
            if(d > dist[u]) continue;
            
            for(int[] e : graph[u]){
                int w = e[0];
                int v = e[1];
                
                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
            
        }
        
        return dist;
    }
}


