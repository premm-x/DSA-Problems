// solution - 2

//  brute - optimal

//  ------------------------------------ ( 1 ) -------------------------------------
// brute approch ( remove every edges temporarily and then check ) --- tc : O(E * (V+E)) sc : O(V)
void dffs(int src, List<List<Integer>> graph, boolean[] visited){
    visited[src] = true;
    
    for(int v : graph.get(src)){
        if(!visited[v]){
            dffs(v, graph, visited);
        }
    }
}

boolean isConnected(int V, List<List<Integer>> graph){
    boolean[] visited = new boolean[V];
    dffs(0, graph, visited);
    
    for(boolean v : visited)
        if(!v) return false;
        
    return true;
}

void bridge(List<List<Integer>> graph, int V){
    for(Integer u=0; u<V; u++){
        for(Integer v : new ArrayList<>(graph.get(u))){
            if(u > v) continue;
            
            graph.get(u).remove(v);
            graph.get(v).remove(u);
            
            if(!isConnected(V, graph)) System.out.println(u +" - "+ v);;
            
            graph.get(u).add(v);
            graph.get(v).add(u);
            
        }
    }
}


//  ------------------------------------ ( 2 ) -------------------------------------
// optima approch ( tarjan algo ) ( used discovey and lowest times ) --- tc : O(V+E) sc : O(V)
class Solution {
    int[] time, lowestTime;
    int ttime;
    boolean[] visited;
    List<List<Integer>> bridges = new ArrayList<>();
    
    void dfs(List<List<Integer>> graph, int V, int src, int parent){
        visited[src] = true;
        
        time[src] = lowestTime[src] = ttime++;
        
        for(int v : graph.get(src)){
            if(v == parent) continue;
            
            if(!visited[v]){
                dfs(graph, V, v, src);
                
                lowestTime[src] = Math.min(lowestTime[v], lowestTime[src]);
                
                if(time[src] < lowestTime[v]){
                    bridges.add(new ArrayList<>(List.of(src, v)));
                }
            }
            else{
                lowestTime[src] = Math.min(lowestTime[src], lowestTime[v]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<V; i++) graph.add(new ArrayList<>());
        
        for(List<Integer> e: edges){
            graph.get(e.get(0)).add(e.get(1));
            graph.get(e.get(1)).add(e.get(0));
        }

        time = new int[V];
        lowestTime = new int[V];
        ttime = 0;
        visited = new boolean[V];
        
        dfs(graph, V, 0, -1);
        
        return bridges;
    }
}






