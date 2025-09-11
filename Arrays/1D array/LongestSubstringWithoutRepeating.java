// brute (optimal) --- O(2n) - sc O(min(n, k)) --- sliding window + hashset/map

public int lengthOfLongestSubstring(String s) {
        
        int maxLength = 0, left = 0;
        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++){

            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }
            else{
                while(set.contains(s.charAt(i)))
                    set.remove(s.charAt(left++));
                
                set.add(s.charAt(i));
            }

            maxLength = Math.max(maxLength, set.size());
        }
        
        return maxLength;
    }
