// solution - 1

// --------------------------------------- ( 1 ) --------------------------------------------
// brute idea ( but optimaized solution ) --- tc: O(M∗N) sc: O(M∗N)
class Solution {
    
    void dfs(char[][] grid, boolean[][] visited, int i, int j){
        visited[i][j] = true;

        int[] dir = {1, 0, -1, 0, 1};
                    // b l t r
        for(int k=1; k<dir.length; k++){
            int r = i + dir[(k-1)];
            int c = j + dir[k];

            if(r < 0 || c < 0 || r >= grid.length || c >= grid[r].length) continue;

            char v = grid[r][c];

            if( !visited[r][c] && v == '1'){
                dfs(grid, visited, r, c);
            }
        }

    }

    public int numIslands(char[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int component = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    component++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return component;
    }
}





