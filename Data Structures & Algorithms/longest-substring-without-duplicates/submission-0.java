class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int l = 0, r = 0, ans = 0, n = s.length();
        Map<Character,Integer> map = new HashMap<>();

        while(r < n)
        {
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0) + 1);

            while( l <= r && map.get(ch) > 1)
            {
                int count = map.get(s.charAt(l));
                count--;
                map.put(s.charAt(l),count);

                l++;
            }

            int len = r-l+1;
            ans = Math.max(ans,len);
            r++;
        }

        return ans;
    }
}
