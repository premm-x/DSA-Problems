// O(n!)

class Solution {

    boolean isSafe(char[][] board, int row, int col){

        for(int i=0; i<board.length; i++){
            if(board[row][i] == 'Q') return false;
        }
        for(int i=0; i<board.length; i++){
            if(board[i][col] == 'Q') return false;
        }
        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        for(int i=row,j=col; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }

    void helper(char[][] board, int row, List<List<String>> ans){

        if(row == board.length){
            ArrayList<String> temp = new ArrayList<>();

            for(char[] i : board){
                temp.add(new String(i));
            }

            ans.add(temp);
            return;
        }

        for(int i=0; i<board.length; i++){
            if(isSafe(board, row, i)){

                board[row][i] = 'Q';
                helper(board, row+1, ans);
                board[row][i] = '.';

            }
        }

    }
     
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        helper(board, 0, ans);
        
        return ans;
    }
}
