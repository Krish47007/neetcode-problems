class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length())
            return false;
        
        int[] s1Freq = new int[26];
        for(char ch : s1.toCharArray())
        {
            s1Freq[ch - 'a']++;
        }
        int k = s1.length();
        int l = 0, r = 0;
        int n = s2.length();

        int[] s2Freq = new int[26];

        while( r < n)
        {
            char ch = s2.charAt(r);
            s2Freq[ch - 'a']++;

            while( l <= r && (r-l+1) > k)
            {
                s2Freq[s2.charAt(l) - 'a']--;
                l++;
            }

            if(r-l+1 == k)
            {
                 if (Arrays.equals(s1Freq, s2Freq)) {
                        return true;
                }
            }

            r++;
        }

        return false;

    }
}
