class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        //If s1 has more char than s2 then permutation of s1 can't be a 
        //substring in s2
        if(s1.length() > s2.length())
            return false;
        
        //Store frequency of each character in s1 
        int[] s1Freq = new int[26];
        for(char ch : s1.toCharArray())
        {
            s1Freq[ch - 'a']++;
        }
        // This would be our sliding window length that we will search in s2
        int k = s1.length();
        int l = 0, r = 0;
        int n = s2.length();

        //Strores the frequency of each character in s2 from sliding window
        int[] s2Freq = new int[26];

        while( r < n)
        {
            char ch = s2.charAt(r);
            s2Freq[ch - 'a']++;

            //If window size is more than k
            while( l <= r && (r-l+1) > k)
            {
                s2Freq[s2.charAt(l) - 'a']--;
                l++;
            }
            //If a valid window then check if charcter freq of each char 
            //from window to s1's char freq.
            if(r-l+1 == k)
            {
                //Compares first array with second array and
                // if all the values from first array match with second then returns true else false
                 if (Arrays.equals(s1Freq, s2Freq)) {
                        return true;
                }
            }

            r++;
        }

        return false;

    }
}
