// solution - 2

// bfs -- easy to understand
class Solution {
    
    boolean bfs(ArrayList<Integer> graph[], int n){
        
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i=0; i<n; i++){
            if(color[i] == -1){
                
                Queue<Integre> q = new ArrayDeque<>();
                q.add(i)
                color[i] = 0;
                
                while(!q.isEmpty()){
                    int node = q.poll();
                    
                    for(int i=0; i<graph[node].size(); i++){
                        int curr = graph[node].get(i);
                        
                        if(color[curr] == -1){
                            color[curr] = 1 - color[node];
                            q.add(curr);
                        }
                        else if(color[curr] == color[node]) return false;
                    }
                }
                
            }
        }
        return true;
    }
    
    public boolean isBipartite(int V, int[][] edges) {
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer> graph[] = new ArrayList[n];
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        return bfs(graph, int n);
    }
}

// ---------------------------------- ( 2 ) -------------------------------------
// dfs -- ghpt answer converted bfs to this dfs
class Solution {

    public boolean dfs(int node, int[] color, int[][] graph) {

        for (int nei : graph[node]) {
            if (color[nei] == -1) {
                color[nei] = 1 - color[node];
                if (!dfs(nei, color, graph))
                    return false;
            } else if (color[nei] == color[node]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (!dfs(i, color, graph))
                    return false;
            }
        }
        return true;
    }
}


 
// ---------------------------------- ( 2 ) -------------------------------------
// dfs -- my logic with ( hashmap + set ) ---- it return wrong answer so first debug it
class Solution {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    
    void dfss(ArrayList<Integer> graph[], int source, boolean[] visited){
        visited[source] = true;
        
        if(!map.containsKey(source)) map.put(source, new ArrayList<>());
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<graph[source].size(); i++){
            Integer curr = graph[source].get(i);
            
            list.add(curr);
            
            if(!visited[curr])
                dfss(graph, curr, visited);
        }
        map.put(source, list);
    }
    
    boolean switchh = true;
    
    boolean dfs(ArrayList<Integer> graph[], int source, boolean[] visited, Set<Integer> s1, Set<Integer> s2){
        visited[source] = true;
        
        if(switchh){
            for(int i : map.get(source)){
                if(!s1.isEmpty() && s1.contains(i)) return false;
            }
            
            s1.add(source);
            switchh = !switchh; 
        }
        else {
            for(int i : map.get(source)){
                if(!s2.isEmpty() && s2.contains(i)) return false;
            }
            
            s2.add(source);
            switchh = !switchh;
        }
        
        for(int i=0; i<graph[source].size(); i++){
            Integer curr = graph[source].get(i);
            
            if(!visited[curr])
                if(!dfs(graph, curr, visited, s1, s2)) return false;
        }
        return true;
    }
    
    public boolean isBipartite(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer> graph[] = new ArrayList[n];
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dfss(graph, 0, new boolean[n]);
        
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        boolean[] visited = new boolean[n];
        
        return dfs(graph, 0, visited, s1, s2);
    }
}


