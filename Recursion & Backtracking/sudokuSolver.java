// O(9^81) (exponential).

class Solution {

    boolean isRight(char[][] board, int row, int col, char d) {

        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] == d)
                return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == d)
                return false;
        }

        // int r = row < 3 ? 0 : (row < 6 ? 3 : 6);
        // int c = col < 3 ? 0 : (col < 6 ? 3 : 6);

        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        for (int i = r; i <= r + 2; i++) {
            for (int j = c; j <= c + 2; j++) {
                if (board[i][j] == d)
                    return false;
            }
        }

        return true;
    }
    
    boolean solver(char[][] board, int row, int col){

        if(col == 9){
           return solver(board, row+1, 0);
        }
        if(row == 9){
            return true;
        }
        
        if(board[row][col] != '.'){
            return solver(board, row, col+1);
        }

        for(char i='1'; i<='9'; i++){
            if(isRight(board, row, col, i)){
                board[row][col] = i;
                if(solver(board, row, col+1)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {

        solver(board, 0, 0);
        
    }
}
