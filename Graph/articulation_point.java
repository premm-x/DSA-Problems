// solution - 1

// dfs -- same as bridge little modify ( children ) --- tc: O(v+e) sc: O(v)
class Solution {
    
    int[] time, low;
    int timeC;
    boolean[] temp;
    boolean[] visited;
    
    void dfs(ArrayList<ArrayList<Integer>> graph, int n, int src, int parent){
        
        visited[src] = true;
        time[src] = low[src] = timeC++;
        int children = 0;
        
        for(Integer v : graph.get(src)){
            if(v == parent) continue;
            
            if(!visited[v]){
                children++;
                
                dfs(graph, n, v, src);
                
                low[src] = Math.min(low[v], low[src]);
                
                if(parent != -1 && low[v] >= time[src]){
                    temp[src] = true;
                }
                
            }
            else{
                low[src] = Math.min(low[src], time[v]);
            }
        }
        
        if(parent == -1 && children > 1) temp[src] = true;
        
    }
    
    
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        time = new int[V];
        low = new int[V];
        visited = new boolean[V];
        temp = new boolean[V];
        timeC = 0;
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(adj, V, i, -1);
            }
        }
        
        for(int i=0; i<V; i++){
            if(temp[i]){
                ans.add(i);
            }
        }
        
        if(ans.isEmpty()) ans.add(-1);
        
        return ans;
    }
}








