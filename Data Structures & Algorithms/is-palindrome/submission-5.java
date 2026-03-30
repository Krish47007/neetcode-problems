class Solution {

    private boolean isAlphanumeric(char ch)
    {
        return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') ||
                    ((ch - '0') >= 0 && (ch - '0') <= 9));

    }
    private boolean equalChars(char x,char y)
    {
        return Character.toLowerCase(x) == Character.toLowerCase(y);
    }

    public boolean isPalindrome(String s) {
        
        int i = 0, j = s.length() - 1;
        int n = s.length();
        char[] str = s.toCharArray();
        boolean ans = true;

        while(i < j)
        {
            //Skip non alphanumeric chars
            while(i < n && !isAlphanumeric(str[i]))
                i++;
             //Skip non alphanumeric chars   
             while(j>= 0 && !isAlphanumeric(str[j]) )
                j--;
            
            if(i < j && !equalChars(str[i],str[j]))
                    return false;
                
            i++;
            j--;

        }

        return true;
    }
}
