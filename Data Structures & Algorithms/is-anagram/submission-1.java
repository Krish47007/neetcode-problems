class Solution {
    public boolean isAnagram(String s, String t) {

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        if(sChars.length != tChars.length)
            return false;

        int[] freq = new int[26];

        for(int i = 0;i < sChars.length;i++)
        {
            freq[sChars[i] - 'a']++;
            freq[tChars[i] - 'a']--;
        }

        for(int val : freq)
        {
            if(val != 0)
                return false;
        }

        return true;
    }
}
