// solution - 2

// ------------------------------------- ( 1 ) -----------------------------------------
// brute force approch --- tc: O( (n*m) * (n*m) )  sc: O(n*m)
class Solution {
    
    boolean dfs(int[][] height, boolean[][] visited, int r, int c, boolean pacific){
        
        if(pacific && (r == 0 || c == 0) ) return true;
        if(!pacific && ( r == height.length-1 || c == height[r].length-1 )) return true;

        visited[r][c] = true;
        int[] dir = { 1, 0, -1, 0, 1 };

        for(int i=1; i<5; i++){
            int x = r + dir[i-1];
            int y = c + dir[i];

            if(x < 0 || y < 0 || x >= height.length || y >= height[x].length ) continue;

            if(!visited[x][y] && height[x][y] <= height[r][c]){
                if(dfs(height, visited, x, y, pacific)) return true;
            }
        }
        return false;
    }

    public List<List<Integer>> pacificAtlantic(int[][] height) {
        
        int r = height.length;
        int c = height[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){

                boolean[][] visited = new boolean[r][c];
                boolean p = dfs(height, visited, i, j, true);
                
                visited = new boolean[r][c];
                boolean a = dfs(height, visited, i, j, false);

                if(p && a){
                    ans.add(new ArrayList(List.of( i, j )));
                }
            }
        }
        return ans;
    }
}


// ------------------------------------- ( 2 ) -----------------------------------------
// optimal approch --- tc: O(n*m)  sc: O(n*m)
class Solution {
    
    void dfs(int[][] h, int r, int c, boolean[][] ocean){
        ocean[r][c] = true;

        int[] dir = { 1, 0, -1, 0, 1 };

        for(int i=0; i<4; i++){
            int x = r + dir[i];
            int y = c + dir[i+1];

            if(x < 0 || y < 0 || x >= h.length || y >= h[0].length) continue;

            if(!ocean[x][y] && h[r][c] <= h[x][y]){
                dfs(h, x, y, ocean);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] h) {
        
        int r = h.length;
        int c = h[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] pac = new boolean[r][c];
        boolean[][] atl = new boolean[r][c];
        
        for(int i=0; i<r; i++) dfs(h, i, 0, pac);
        for(int i=0; i<c; i++) dfs(h, 0, i, pac);

        for(int i=0; i<r; i++) dfs(h, i, c-1, atl);
        for(int i=0; i<c; i++) dfs(h, r-1, i, atl);

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(pac[i][j] && atl[i][j]){
                    ans.add(List.of( i, j ));
                }
            }
        }

        return ans;
    }
}

