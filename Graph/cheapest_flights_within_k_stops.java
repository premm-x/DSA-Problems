// solution - 1

// dijikstra modified --- tc: O(V*E) sc: O(V*E)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int[] e : flights){
            adj.get(e[0]).add( new int[]{ e[1], e[2] } );
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // node, dist, level
        Queue<int[]> pq = new ArrayDeque<>();

        pq.add(new int[]{ src, 0, 0 });

        int ans = -1;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];
            int level = curr[2];

            if(level > k) continue;

            for(int[] v : adj.get(node)){
                int vNode = v[0];
                int wt = v[1];

                if(d + wt < dist[vNode]){
                    dist[vNode] = d + wt;
                    
                    if(level <= k && dst == vNode) ans = dist[vNode];

                    pq.add(new int[]{ vNode, dist[vNode], level+1 });
                }

            }

        }
        return ans;
    }
}


