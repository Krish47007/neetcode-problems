class Solution {

    public String mergeAlternately(String word1, String word2) {
        
        int n = word1.length(), m = word2.length();
        int i = 0, j = 0;
        StringBuilder ans = new StringBuilder();
        boolean flag = true;

        while( i < n && j < m)
        {
            if(flag)
            {
                ans.append(word1.charAt(i));
                i++;
            }
            else
            {
                ans.append(word2.charAt(j));
                j++;
            }

            flag = !flag;
        }

        //Add leftover
        while(i < n)
        {
            ans.append(word1.charAt(i));
            i++;
        }
        while(j < m)
        {
            ans.append(word2.charAt(j));
            j++;
        }

        return ans.toString();
    }
}