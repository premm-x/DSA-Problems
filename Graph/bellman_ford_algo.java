// solution - 1

// V-1 times with ( main is relaxationa ) --- tc: O(V*E) sc: O(V)
class Solution {
    public int[] bellmanFord(int n, int[][] edges, int src) {

        int dist[] = new int[n];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        for (int k = 0; k < n; k++) {
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int w = e[2];

                if (dist[u] != (int) 1e8 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            if (dist[u] != (int) 1e8 && dist[u] + w < dist[v]) {
                return new int[] { -1 };
            }
        }

        return dist;
    }   
}
