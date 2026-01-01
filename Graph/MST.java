// solution - 1

// brute mst - kruskal - prims

//brute force approch ( not optimazied ) --- tc: O((V + E) log V) sc: O(V + E)
class Solution {

    static boolean hasCycle(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                if (hasCycle(nei, node, visited, graph))
                    return true;
            } else if (nei != parent) {
                return true;
            }
        }
        return false;
    }
    
    public int spanningTree(int V, int[][] edges) {
        
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        int totalWeight = 0;
        int edgeCount = 0;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            // add edge
            graph.get(u).add(v);
            graph.get(v).add(u);

            boolean[] visited = new boolean[V];
            if (hasCycle(u, -1, visited, graph)) {
                // remove edge if cycle
                graph.get(u).remove(graph.get(u).size() - 1);
                graph.get(v).remove(graph.get(v).size() - 1);
            } else {
                totalWeight += w;
                edgeCount++;
                if (edgeCount == V - 1) break;
            }
        }
        return totalWeight;
        
    }
}


