// solution - 2

// brute --- tc: O((n*m)^2)  sc: O(n*m)
class Solution {

    boolean isSurrounded(char[][] board, boolean[][] visited, int r, int c, ArrayList<int[]> cell){
        
        visited[r][c] = true;
        cell.add(new int[]{ r, c });

        boolean surrounded = true;

        if( r == 0 || r == board.length-1 || c == 0 || c == board[r].length-1 ) surrounded = false;

        int[] dir = { 1, 0, -1, 0, 1 };

        for(int i=1; i<5; i++){
            int x = r + dir[i-1];
            int y = c + dir[i];

            if( x < 0 || y < 0 || x >= board.length || y >= board[r].length ) continue;
            
            if(!visited[x][y] && board[x][y] == 'O'){
                if(!isSurrounded(board, visited, x, y, cell)){
                    surrounded = false;
                }
            }
        }
        return surrounded;
    }

    public void solve(char[][] board) {

        int r = board.length;
        int c = board[0].length;
        
        boolean[][] visited = new boolean[r][c];

        for(int i=1; i<r-1; i++){
            for(int j=1; j<c-1; j++){
                
                if(!visited[i][j] && board[i][j] == 'O'){
                    ArrayList<int[]> cell = new ArrayList<>();
                    if(isSurrounded(board, visited, i, j, cell)){
                        for(int[] k : cell){
                            board[k[0]][k[1]] = 'X';
                        }
                    }
                }
            }
        }
    }
}

// optimal --- tc: O(n*m)  sc: O(n*m) (DFS stack)
class Solution {

    void dfs(char[][] board, int r, int c){
        board[r][c] = '#';

        int[] dir = { 1, 0, -1, 0, 1 };

        for(int i=1; i<5; i++){
            int x = r + dir[i-1];
            int y = c + dir[i];

            if( x < 0 || y < 0 || x >= board.length || y >= board[x].length ) continue;
            
            if(board[x][y] == 'O'){
                dfs(board, x, y);
            }
        }
    }

    public void solve(char[][] board) {

        int r = board.length;
        int c = board[0].length;

        for(int i=0; i<c; i++){
            if(board[0][i] == 'O') dfs(board, 0, i);
            if(board[r-1][i] == 'O') dfs(board, r-1, i);            
        }

        for(int i=0; i<r; i++){
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][c-1] == 'O') dfs(board, i, c-1);      
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}


