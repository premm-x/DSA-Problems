// solution - 2

// dfs -- stack ( common and simple one )
class Solution {
    
    void dfs(ArrayList<Integer> graph[], int source, boolean[] visited, Stack<Integer> st){
        
        visited[source] = true;
        
        for(int curr : graph[source]){
            if(!visited[curr]) dfs(graph, curr, visited, st);
        }
        
        st.push(source);
    }
    
    public ArrayList<Integer> topoSort(int n, int[][] edges) {
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer> graph[] = new ArrayList[n];
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
        }
        
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            if(!visited[i])
                dfs(graph, i, visited, st);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!st.isEmpty()) ans.add(st.pop());
        
        return ans;
    }
}

// -------------------------------------- ( 2 ) ------------------------------------------
// bfs -- using indegree ( incoming edges ) array 
class Solution {
    
    public ArrayList<Integer> topoSort(int n, int[][] edges) {
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer> graph[] = new ArrayList[n];
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        int[] incoming = new int[graph.length];
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            incoming[e[1]]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            if(incoming[i] == 0) q.add(i);
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            topo.add(node);
            
            for(int curr : graph[node]){
                incoming[curr]--;
                if(incoming[curr] == 0) q.add(curr);
            }
            
        }
        return topo;
    }
}










