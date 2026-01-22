// solution - 1

// optimal ( bfs approch ) tc: O(n*m) sc: O(n*m)
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] == 1) return -1;

        int r = grid.length;
        int c = grid[0].length;
        
        boolean[][] visited = new boolean[r][c];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{ 0, 0, 1 });
        
        visited[0][0] = true;
        
        int[][] dir = { 
            { 1,0 },
            { 1,-1 },
            { 0,-1 },
            { -1,-1 },
            { -1,0 },
            { -1,1 },
            { 0,1 },
            { 1,1 },
        };
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];
            
            if( r-1 == x && r-1 == y ) return time;
            
            for(int i=0; i<dir.length; i++){
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                
                if(newX < 0 || newY < 0 || newX >= r || newY >= c) continue;
                
                if(!visited[newX][newY] && grid[newX][newY] == 0){
                    
                    visited[newX][newY] = true;
                    q.add(new int[]{ newX, newY, time+1 });
                    
                }
                
            }
            
        }
        return -1;
    }
}


