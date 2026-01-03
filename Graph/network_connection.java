// solution - 1

// dsu --- tc: O(E) sc: O(n)
class Solution {
    
    int[] parent;

    int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);

        return parent[x];
    }

    void union(int x, int y){
        int px = find(x);
        int py = find(y);
        
        if(px != py) parent[py] = px;
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1 ) return -1;

        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        for(int[] e: connections){
            union(e[0], e[1]);
        }

        int cabel = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i) cabel++;
        }

        return cabel-1;
    }
}




