// solution - 2

// dsu by rank (rank, path compression are the count under the optimal)
class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // path compression
        return parent[x];
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false; // cycle

        // union by rank
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
}

// ---------------------------------------- ( 2 ) ------------------------------------------
// dsu by size (size, path compression are the count under the optimal)
class GfG {
    int find(int par[], int x) {
        if(par[x] == x) return x;
        
        return find(par, par[x]);
    }
    
    int[] size = new int[101];
    Arrays.fill(size, 1);

    void unionSet(int par[], int x, int z) {
        
        int pf = find(par, x);
        int ps = find(par, z);
      
        if(pf == ps) return;
      
        int pfSize = size[pf];
        int psSize = size[ps];
      
        if(pfSize < psSize){
            par[pf] = ps;
            size[ps] += size[pf];
        }
        else{
            par[ps] = pf;
            size[pf] += size[ps];
        }
    }
}





