// solution - 1 (2)

// unweighted mean every edges have consider 1 as weight to compare the shortest

// bfs --- tc: (v + e) sc: O(v)
class Solution {
    
    void bfs(ArrayList<Integer> graph[], int src, int[] ans){
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        ans[src] = 0;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int nei : graph[curr]){
                if(ans[nei] == -1){
                    ans[nei] = ans[curr] + 1;
                    q.add(nei);
                }
            }
        }
        
    }
    
    public int[] shortestPath(int n, int[][] edges, int src) {
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer> graph[] = new ArrayList[n];
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        int[] ans = new int[n];
        
        Arrays.fill(ans, -1);

        bfs(graph, src, ans);
        
        return ans;
    }
}


// ------------------------------------------- ( 2 ) ------------------------------------------------
// dfs - dfs generally fail in shortest path question but good to understand the concept
// --- tc: O( 2^V ) sc: (v)
class Solution {
    int w = -1;
    
    void dfs(ArrayList<Integer> graph[], int src, boolean[] visited, int[] ans){
        visited[src] = true;
        w++;
        
        if(ans[src] == -1 || ans[src] > w) ans[src] = w;
        
        for(int curr : graph[src]){
            if(!visited[curr]){
                if(ans[curr] != -1 && ans[curr] <= w+1) continue;
              
                dfs(graph, curr, visited, ans);
            }
        }
        
        visited[src] = false;
        w--;
    }
    
    public int[] shortestPath(int n, int[][] edges, int src) {
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer> graph[] = new ArrayList[n];
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        
        Arrays.fill(ans, -1);

        dfs(graph, src, visited, ans);
        
        return ans;
    }
}














