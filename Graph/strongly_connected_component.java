// solution - 2

// brute -- optimal ( kosaraju ) -- optimal ( tarjan )

// --------------------------------------- ( 1 ) ---------------------------------------------
// brute force --- tc: O(V * (V+E)) sc: O(V²)
class Solution {

    void dfs(ArrayList<ArrayList<Integer>> graph, int u, boolean[] visited){
        visited[u] = true;
        
        for(int v : graph.get(u)){
            if(!visited[v]){
                dfs(graph, v, visited);
            }
        }
    }
    
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        
        boolean[][] mat = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            boolean visited[] = new boolean[n];

            dfs(adj, i, visited);
            
            for(int j=0; j<n; j++){
                mat[i][j] = visited[j];
            }
        }
        
        boolean used[] = new boolean[n];
        int scc = 0;
        
        for(int i=0; i<n; i++){
            if(used[i]) continue;
            scc++;
            
            for(int j=0; j<n; j++){
                if(!used[j] && (mat[i][j] && mat[j][i]) ){
                    used[j] = true;
                }
            }
        }
        
        return scc;
    }
}

// --------------------------------------- ( 2 ) ---------------------------------------------
// optimal ( kosaraju algo ) --- tc: O(V+E) sc: O(V+E)
class Solution {
    
    Stack<Integer> st = new Stack<>();
    
    void dfsStack(ArrayList<ArrayList<Integer>> graph, int u, boolean[] visited){
        visited[u] = true;
        
        for(int v : graph.get(u)){
            if(!visited[v]){
                dfsStack(graph, v, visited);
            }
        }
        st.push(u);
    }
    
    void dfs(ArrayList<ArrayList<Integer>> graph, int u, boolean[] visited){
        visited[u] = true;
        
        for(int v : graph.get(u)){
            if(!visited[v]){
                dfs(graph, v, visited);
            }
        }
    }
    
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        
        boolean visited[] = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfsStack(adj, i, visited);
            }
        }
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        
        for(int u=0; u<n; u++){
            for(int v : adj.get(u)){
                graph.get(v).add(u);
            }
        }
        
        visited = new boolean[n];
        int scc = 0;
        
        while(!st.isEmpty()){
            int i = st.pop();
            
            if(!visited[i]){
                scc++;
                dfs(graph, i, visited);
            }
        }
        
        return scc;
    }
}








