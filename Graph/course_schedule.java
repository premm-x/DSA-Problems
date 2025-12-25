// solution - 2

// bfs -- same technique as the topo sort bfs ( kahn's algo )
public boolean canFinish(int numCourses, int[][] prerequisites) {

    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
        adj.add(new ArrayList<>());
    }

    int[] indegree = new int[numCourses];

    // Build graph
    for (int[] p : prerequisites) {
        int course = p[0];
        int prereq = p[1];
        adj.get(prereq).add(course);
        indegree[course]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) q.add(i);
    }

    int count = 0;

    while (!q.isEmpty()) {
        int node = q.poll();
        count++;

        for (int nei : adj.get(node)) {
            indegree[nei]--;
            if (indegree[nei] == 0) {
                q.add(nei);
            }
        }
    }

    return count == numCourses;
}

// ------------------------------------------- ( 2 ) ------------------------------------------------
// dfs -- we check for cucle if exist we return true which make false
class Solution {
    
    boolean hasCycle(ArrayList<Integer> graph[], int source, int[] state){
        state[source] = 1;

        for(int nei : graph[source]){
            if(state[nei] == 1) return true;
            if(state[nei] == 0 && hasCycle(graph, nei, state)) return true;
        }

        state[source] = 2;
        return false;
    }

    public boolean canFinish(int n, int[][] edges) {
        
        // @SuppressWarnings("unchecked")
        ArrayList<Integer> graph[] = new ArrayList[n];
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
        }
        
        int[] state = new int[n];

        for(int i=0; i<n; i++){
            if(state[i] == 0 && hasCycle(graph, i, state)) return false;
        }

        return true;
    }
}

