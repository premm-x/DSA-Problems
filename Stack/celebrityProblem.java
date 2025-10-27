// solution - 2

// stack --- tc: O(n) sc: O(n)
class Solution {
    public int celebrity(int mat[][]) {
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<mat.length; i++)
            st.push(i);
            
        while(st.size() != 1){
            int p1 = st.pop();
            int p2 = st.pop();
            
            if(mat[p1][p2] == 1) st.push(p2);
            else st.push(p1);
        }
        int cele = st.pop();
        for(int i=0; i<mat.length; i++){
            if(i != cele && (mat[i][cele] == 0 || mat[cele][i] == 1)) return -1;
        }
        
        return cele;
    }
}
// ------------------------------------ ( 2 ) ----------------------------------------
// optimaized --- tc: O(n) sc: O(1)
class Solution {
    public int celebrity(int mat[][]) {
        
        int h = mat.length-1;
        int l = h-1;
        
        while(l >= 0){  // --- while(h >= 0 && l >= 0){
            if(mat[h][l] == 1){
                h = l;
                l--;
            }
            else l--;  
        }
        int cele = h;  // --- int cele = ( h < 0 ) ? l : h ;
      
        for(int i=0; i<mat.length; i++){
            if(i != cele && (mat[i][cele] == 0 || mat[cele][i] == 1)) return -1;
        }
        
        return cele;
    }
}
