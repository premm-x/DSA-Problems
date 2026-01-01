// solution - 2

// brute - optimal

// brute approch ( finding min edges every time ) --- tc: O(v*E) sc: O(v)
class Solution {
    public int spanningTree(int V, int[][] edges) {
        
        boolean visited[] = new boolean[V];
        visited[0] = true;
        
        int mstCost = 0;
        int edgesCount = 0;
        
        while(edgesCount < V-1){
            
            int minW = Integer.MAX_VALUE;
            int u = -1;
            int v = -1;
            
            for(int[] e : edges){
                
                if(visited[e[0]] && !visited[e[1]] ||
                   visited[e[1]] && !visited[e[0]] ){
                       
                    if(e[2] < minW){
                        minW = e[2];
                        u = e[0];
                        v = e[1];
                    }
                       
                }
            }
            
            mstCost += minW;
            visited[u] = true;
            visited[v] = true;
            edgesCount++;
        }
        
        return mstCost;
    }
}

// ---------------------------------------- ( 2 ) --------------------------------------------
// optimal approch ( Priority Queue to get smallest edge) --- tc: O(E log V) sc: O(v + E)
class Solution {
    public int spanningTree(int V, int[][] edges) {
        
        @SuppressWarnings("unchecked")
        ArrayList<int[]> graph[] = new ArrayList[V];
        
        for(int i=0; i<V; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges){
            graph[e[0]].add(new int[]{ e[1], e[2] });
            graph[e[1]].add(new int[]{ e[0], e[2] });
        }
        
        boolean visited[] = new boolean[V];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{ 0, 0 });
        
        int mstCost = 0;
            
        while(!pq.isEmpty()){
            
            int[] curr = pq.poll();
            int node = curr[0];
            int wt = curr[1];
            
            if(visited[node]) continue;
            
            visited[node] = true;
            mstCost += wt;
            
            for(int[] i : graph[node] ){
                int v = i[0];
                int vWt = i[1];
                
                if(!visited[v]){
                    pq.add(new int[]{ v, vWt });
                }
            }
        }

        return mstCost;
    }
}















