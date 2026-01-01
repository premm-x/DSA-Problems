// solution - 1

// dsu ( do not travel the edge twice ( u - v ) or ( v - u ) travel only once  ) --- tc: O(E) sc: O(V)
class Solution {
    
    int[] parent;
    
    int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        
        return parent[x];
    }
    
    boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        
        if(px == py) return false;
        
        parent[py] = px;
        
        return true;
    }
    
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        parent = new int[V];
        for(int i=0; i<V; i++) parent[i] = i;
        
        ArrayList<int[]> edges = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            for(int j : adj.get(i)){
                if(i < j){
                    edges.add(new int[]{i, j});
                }
            }
        }
        
        for(int[] e : edges){
            if(!union(e[0], e[1])) return 1;
        }
        
        return 0;
    }
}



