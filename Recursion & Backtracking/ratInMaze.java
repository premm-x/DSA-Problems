// O(4ⁿ²) n² - n is this way tc 
// teach -- ( avoiding infinit loop (same path issuse))

class Solution {
    
    void helper(int[][] maze, int row, int col, ArrayList<String> ans, String path){
        
        if(row < 0 || row >= maze.length) return;
        if(col < 0 || col >= maze.length) return;
        
        if(maze[row][col] == 0 || maze[row][col] == -1) return;
        
        if(row == maze.length-1 && col == maze.length-1){
            ans.add(path);
            return;
        }
        
        maze[row][col] = -1;
        
        helper(maze, row+1, col, ans, path+"D");
        helper(maze, row, col-1, ans, path+"L");
        helper(maze, row, col+1, ans, path+"R");
        helper(maze, row-1, col, ans, path+"U");
        
        maze[row][col] = 1;
        
    }
 
    public ArrayList<String> ratInMaze(int[][] maze) {

        ArrayList<String> ans = new ArrayList<>();
        
        helper(maze, 0, 0, ans, "");
        
        
        return ans;
    }
}
