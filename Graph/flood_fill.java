// solution - 2


// --------------------------------------- ( 1 ) ---------------------------------------------
// brute ( with visited array ) --- tc: O(N * M)  sc:O(N * M) 
class Solution {
    
    void dfs(int[][] image, int sr, int sc, int color, boolean[][] visited, int base){
        visited[sr][sc] = true;
        
        int[] dir = {1, 0, -1, 0, 1};

        for(int i=1; i<5; i++){
            int r = sr + dir[i-1];
            int c = sc + dir[i];
            
            if(r < 0 || c < 0 || r >= image.length || c >= image[r].length) continue;
            
            if(!visited[r][c] && image[r][c] == base){
                dfs(image, r, c, color, visited, base);
            }
        }

        image[sr][sc] = color;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        boolean[][] visited = new boolean[image.length][image[0].length];

        if(image[sr][sc] != color){
            dfs(image, sr, sc, color, visited, image[sr][sc]);
        }

        return image;
    }
}

// --------------------------------------- ( 2 ) ---------------------------------------------
// optimazied ( without visited array ) --- tc: O(N * M) sc:O(1) ( but recursion so it sc:O(N * M) )
class Solution {
    
    void dfs(int[][] image, int sr, int sc, int color, int base){
        image[sr][sc] = color;
        
        int[] dir = {1, 0, -1, 0, 1};

        for(int i=1; i<5; i++){
            int r = sr + dir[i-1];
            int c = sc + dir[i];
            
            if(r < 0 || c < 0 || r >= image.length || c >= image[r].length) continue;
            
            if(image[r][c] == base){
                dfs(image, r, c, color, base);
            }
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] != color){
            dfs(image, sr, sc, color, image[sr][sc]);
        }

        return image;
    }
}
