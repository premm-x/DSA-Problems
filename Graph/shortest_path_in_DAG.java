// solution - 1

// topo sort then relaxaton ( two step process ) --- tc: O(V+E) sc: O(V)
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        
        @SuppressWarnings("unchecked")
        ArrayList<int[]> graph[] = new ArrayList[V];
        
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
        
        int incoming[] = new int[V];
        
        for(int[] e : edges){
            graph[e[0]].add(new int[]{ e[1], e[2] });
            incoming[e[1]]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<V; i++){
            if(incoming[i] == 0){
                q.add(i);
            }
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            topo.add(node);
            
            for(int[] e : graph[node] ){
                int v = e[0];
                
                incoming[v]--;
                if(incoming[v] == 0){
                    q.add(v);
                }
            }
        }
        
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        for(int i=0; i<topo.size(); i++){
            int curr = topo.get(i);
            
            for(int[] e : graph[curr]){
                int v = e[0];
                int w = e[1];
                
                if(dist[curr] != Integer.MAX_VALUE && dist[curr] + w < dist[v]){
                    dist[v] = dist[curr] + w;
                }
            }
        }
        
        for(int i=0; i<V; i++)
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        
        return dist;
    }
}





