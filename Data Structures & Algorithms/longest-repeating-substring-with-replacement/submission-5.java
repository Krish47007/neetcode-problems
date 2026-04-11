class Solution {
    private int getMaxFreq(int[] ch)
    {
        int freq = 0;
        for(int i = 0; i < ch.length;i++)
        {
            if(ch[i] > freq)
                freq = ch[i];
        }
        return freq;
    }

    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        int l = 0, r = 0;
        int[] ch = new int[26];
        int ans = 0;
        while( r < n)
        {
            ch[s.charAt(r) - 'A']++;
            int wl = r - l + 1;
            while( l <= r && (wl - getMaxFreq(ch)) > k)
            {
                ch[s.charAt(l) - 'A']--;
                l++;
                wl = r - l + 1;
            }
            ans = Math.max(ans,wl);
            r++;
        }
        return ans;
    }
}
