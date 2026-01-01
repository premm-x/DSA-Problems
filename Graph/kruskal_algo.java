// solution - 1
// This is a greedy algorithm. 

// mst optimazied with dsu ( kruskal's algo ) --- tc: O(E log E) sc: O(V)
class Solution {

    int parent[];
    
    int find(int x){
        if(parent[x] != x)
            parent[x] = find(parent[x]);
            
        return parent[x];
    }
    
    boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        
        if(px == py) return false;
        
        parent[py] = px;
        
        return true;
    }
    
    public int spanningTree(int V, int[][] edges) {
        
        parent = new int[V];
        for(int i=0; i<V; i++) parent[i] = i;
        
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int totalWeight = 0;
        int edgeCount = 0;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            if(!union(u, v)) continue;
            
            totalWeight += w;
            edgeCount++;
            if(edgeCount == V-1) break;
        }
        
        return totalWeight;
    }
}


