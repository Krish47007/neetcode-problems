class Solution {

    private int getMaxCharFreq(Map<Character,Integer> map)
    {
        int maxFreq = 0;
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            if(entry.getValue() > maxFreq)
            {
                maxFreq = entry.getValue();
            }
        }

        return maxFreq;
    }

    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        int l = 0, r = 0;
        //Stores count of each character in a window
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;

        while(r < n)
        {
            //Put current char's count in map
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0) + 1);
            //Check current window length
            int wl = r - l + 1;

            while(l <= r && (wl - getMaxCharFreq(map)) > k)
            {
                char ch = s.charAt(l);
                int count = map.get(ch) - 1;
                if(count > 0)
                    map.put(ch,count);
                else
                    map.remove(ch);
                
                l++;
                wl = r - l + 1;
            }
            //Take the window length and check if its > earlier ans
            ans = Math.max(ans,wl);
            //move forward
            r++;

        }

        return ans;
    }
}
