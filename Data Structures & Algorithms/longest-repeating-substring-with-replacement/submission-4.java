class Solution {

    private int getMaxCharFreq(int[] freq)
    {
        int maxFreq = 0;
        for(int c : freq)
        {
            if( c > maxFreq)
                maxFreq = c;
        }

        return maxFreq;
    }

    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        int l = 0, r = 0;
        //Stores count of each character in a window
        int[] freq = new int[26];
        int ans = 0;

        while(r < n)
        {
            //Put current char's count in map
            freq[s.charAt(r) - 'A']++;
            //Check current window length
            int wl = r - l + 1;

            while(l <= r && (wl - getMaxCharFreq(freq)) > k)
            {
                char ch = s.charAt(l);
                //Reduce the frequency
                freq[ch - 'A']--;
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
