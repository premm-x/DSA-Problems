// solution - 2

// brute - optimal

//----------------------------------- ( 1 ) -----------------------------------------
// brute --- tc: O( n²*L )  sc: O( n*L ) -( basically n word )
class Solution {
    int ans = 1;

    public int ladderLength(String start, String end, List<String> list) {
        int n = list.size();

        Queue<String> q = new ArrayDeque<>();
        q.add(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(end)) return ans;

                for (String s : list) {
                    int diffOne = 0;

                    for (int j = 0; j < curr.length(); j++) {
                        if (curr.charAt(j) != s.charAt(j)) diffOne++;
                    }

                    if (!visited.contains(s) && diffOne == 1) {
                        q.add(s);
                        visited.add(s);
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}


//----------------------------------- ( 2 ) -----------------------------------------
// optimal --- tc: O( n*L*26 )  sc: O( n*L ) -( basically n word )
class Solution {
    public int ladderLength(String start, String end, List<String> list) {
        int n = list.size();

        Set<String> dict = new HashSet<>(list);
        if(!list.contains(end)) return 0;

        Queue<String> q = new ArrayDeque<>();
        q.add(start);
        int ans = 1;

        Set<String> visited = new HashSet<>();
        visited.add(start);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(end)) return ans;

                char[] arr = curr.toCharArray();

                for (int j=0; j<arr.length; j++) {
                    char old = arr[j];

                    for(char k='a'; k<='z'; k++){
                        arr[j] = k;

                        String next = new String(arr);

                        if(dict.contains(next) && !visited.contains(next)){
                            visited.add(next);
                            q.add(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            ans++;
        }
        return 0;
    }
}



