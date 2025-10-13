// solution - 1

// stack --- tc: O(n) sc: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char letter = s.charAt(i);

            if(letter == '(' || letter == '[' || letter == '{'){
                st.push(letter);
            }
            else{
                
                if(st.isEmpty()) return false;

                char top = st.peek();
                if(top == '(' && letter == ')' || top == '[' && letter == ']' || top == '{' && letter == '}'){
                    st.pop();
                }  
                else return false;
            }
        }
        return st.isEmpty();
    }
}
