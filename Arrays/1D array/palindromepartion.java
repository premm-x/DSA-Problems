// O(n * ₂n) --- 

class Solution {

    boolean isPalindrome(String str){

        int s = 0, end = str.length()-1;

        while(s <= end)
            if(str.charAt(s++) != str.charAt(end--)) return false;

        return true;
    }

    void helper(String s, ArrayList<String> arr, List<List<String>> ans){

        if(s.length() == 0){
            ans.add(new ArrayList<>(arr));
            return;
        }
        
        for(int i=0; i<s.length(); i++){

            String part = s.substring(0, i+1);

            if(isPalindrome(part)){
                arr.add(part);
                helper(s.substring(i+1), arr, ans);
                arr.removeLast();
            }
        }

    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> arr = new ArrayList<>();

        helper(s, arr, ans);

        return ans;
    }
}
