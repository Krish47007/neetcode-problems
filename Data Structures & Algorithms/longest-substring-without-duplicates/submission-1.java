class Solution {

    public int lengthOfLongestSubstring(String s) {
        
        Map<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0, r = 0;
        int n = s.length();

        while(r < n)
        {
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0) + 1);

            while(l < r && map.get(ch) > 1)
            {
                char leftChar = s.charAt(l);
                int count = map.get(leftChar) - 1;
                if(count == 0)
                    map.remove(leftChar);
                else
                    map.put(leftChar,count);

                l++;
            } 

            int len = r-l+1;
            maxLen = Math.max(len,maxLen); 
            r++;          
        }

        return maxLen;
    }
}
