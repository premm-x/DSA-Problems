// solution - 1

// dfs 
class Solution {
    
    ArrayList<Integer> dfs(ArrayList<Integer> graph[], int source, boolean[] visited, ArrayList<Integer> cc){
        visited[source] = true;
        cc.add(source);

        for(int i=0; i<graph[source].size(); i++){
            Integer des = graph[source].get(i);

            if(!visited[des])
                dfs(graph, des, visited, cc);
        }
        
        return cc;
    }

    
    public ArrayList<ArrayList<Integer>> getComponents(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer> graph[] = new ArrayList[n];

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int connectedComponent = 0;
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(!visited[i]){
                ans.add( dfs(graph, i, visited, new ArrayList<>()) );
                connectedComponent++;
            }
        }

        return ans;
    }
}


