class Solution {
    public boolean isAnagram(String s, String t) {

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        if(sChars.length != tChars.length)
            return false;

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for(int i = 0; i < sChars.length;i++)
        {
            if(sChars[i] != tChars[i])
                return false;
        }

        return true;
    }
}
