// brute --- (print -1 rather 0 then replace) --- O(n³)

// optimal (use row[] & col[] for marking ) --- O(m * n) - sc O(n) + O(m)

// optimal ( make row[] & col[] inside the matrix **reduce sc**) --- O(m * n)

public void setZeroes(int[][] mat) {

        int col0 = 1;
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j] == 0){
                    
                    mat[i][0] = 0;

                    if(j != 0)
                        mat[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for(int i=1; i<mat.length; i++){
            for(int j=1; j<mat[i].length; j++){
                if(mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }

        if(mat[0][0] == 0){
            for(int i=0; i<mat[0].length; i++){
                mat[0][i] = 0;
            }
        }

        if(col0 == 0){
            for(int i=0; i<mat.length; i++){
                mat[i][0] = 0;
            }
        }

    }
