// solution - 3
                                 👍
// ( 1.build-in function, 2.queue based -best one, 3.manual -avg )

// build in function --- tc: O(n log i) sc: O(n log i)
class Solution {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> ans = new ArrayList<>();
        for(int i=1; i<=n; i++){
            ans.add(Integer.toBinaryString(i));
        }
        return ans;
    }
}

// --------------------------------- ( 2 ) ------------------------------------
// queue based + simple logic --- tc: O(n) sc: O(n)
class Solution {
    public ArrayList<String> generateBinary(int len) {
        
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer("1");
        
        for(int i=1; i<=len; i++){
            
            String num = q.poll();
            ans.add(num);
            
            q.offer(num + "0");
            q.offer(num + "1");
        }
        return ans;
    }
}
// -- same for 2 but optimaized use while rather then for loop decrease queue extra storage
ArrayList<String> ans = new ArrayList<>();
Queue<String> q = new ArrayDeque<>();
q.offer("1");
        
   while (len-- > 0){
            
      String num = q.poll();
      ans.add(num);
            
      if(q.size() < len){
          q.offer(num + "0");
          q.offer(num + "1");
      }
    }

// --------------------------------- ( 3 ) ------------------------------------
// manual logic --- tc: O(n log i) sc: O(n log i)
class Solution {
    public ArrayList<String> generateBinary(int len) {
        
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i=1; i<=len; i++){
            
            StringBuilder s = new StringBuilder();
            int n = i;
            
            while(n > 0){
                s.append(n % 2);
                n = n/2;
            }
            ans.add(s.reverse().toString());
        }
        return ans;
    }
}
