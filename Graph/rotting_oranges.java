// solution - 2

//-------------------------------- ( 1 ) ------------------------------------
// brute my logic ( bfs i think optimal ) --- tc: O(N * M) sc: O(N * M)
class Solution {

    public int orangesRotting(int[][] grid) {
        int rr = grid.length;
        int cc = grid[0].length;

        int time = -1;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<rr; i++){
            for(int j=0; j<cc; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{ i, j });
                }
            }   
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                
                if( r+1 < grid.length && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    q.add(new int[]{ r+1, c });
                }

                if( c-1 >= 0 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    q.add(new int[]{ r, c-1 });
                }

                if( r-1 >= 0 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    q.add(new int[]{ r-1, c });
                }

                if( c+1 < grid[r].length && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    q.add(new int[]{ r, c+1 });
                }

            }

            time++;
        }

        for(int i=0; i<rr; i++){
            for(int j=0; j<cc; j++){
                if(grid[i][j] == 1) return -1;
            }   
        }

        return time == -1 ? 0 : time;
    }
}


//-------------------------------- ( 2 ) ------------------------------------
// same but more clear and edge cases discribed --- tc: O(N * M) sc: O(N * M)
class Solution {

    public int orangesRotting(int[][] grid) {
        int rr = grid.length;
        int cc = grid[0].length;

        int time = 0;
        int fresh = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<rr; i++){
            for(int j=0; j<cc; j++){
                if(grid[i][j] == 2) q.add(new int[]{ i, j });
                if(grid[i][j] == 1) fresh++;                
            }   
        }

        if(fresh == 0) return 0;

        int[] dir = {1, 0, -1, 0, 1};

        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                
                for(int k=1; k<5; k++){
                    int x = r + dir[k-1];
                    int y = c + dir[k];

                    if( x >=0 && y >=0 && x < grid.length && y < grid[x].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        q.add(new int[]{ x, y });
                        rotted = true;
                        fresh--;
                    }
                }

            }

            if(rotted) time++;
        }

        return fresh == 0 ? time : -1;
    }
}




