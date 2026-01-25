// solution - 1

// must practice

// optimal  ---  tc: O(v*e) sc: O(v)
class Solution {
    static class Edge {
        int to, wt;
        Edge(int t, int w) {
            to = t;
            wt = w;
        }
    }

    public int[] zeroOneBFS(int V, ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();
        dist[src] = 0;
        dq.addFirst(src);

        while (!dq.isEmpty()) {
            int u = dq.pollFirst();

            for (Edge e : graph[u]) {
                int v = e.to;
                int w = e.wt;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;

                    if (w == 0)
                        dq.addFirst(v);
                    else
                        dq.addLast(v);
                }
            }
        }
        return dist;
    }
}


