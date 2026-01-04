// solution - 1

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
// brute approch ( remove every edges temporarily and then check ) --- tc : O(E * (V+E)) sc : O(V)







