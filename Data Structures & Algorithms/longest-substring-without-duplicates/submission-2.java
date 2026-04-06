class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int l = 0, r = 0;
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();

        while(r < n)
        {
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0) + 1);

            while( l < r && map.get(ch) > 1)
            {
                char temp = s.charAt(l);
                int count = map.get(temp) - 1;
                if(count > 0)
                    map.put(temp,count);
                else
                    map.remove(temp);
                
                l++;
            }

            int len = r - l + 1;
            maxLen = Math.max(maxLen,len);
            r++;
        }

        return maxLen;
    }
}
