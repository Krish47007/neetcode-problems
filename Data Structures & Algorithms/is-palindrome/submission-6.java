class Solution {


    public boolean isPalindrome(String s) {
        
        char str[] = s.toCharArray();
        int beg = 0, end = str.length - 1;

        while(beg < end)
        {
            if(!Character.isLetterOrDigit(str[beg]))
                beg++;
            else if(!Character.isLetterOrDigit(str[end]))
                end--;
            else
            {
                if(Character.toLowerCase(str[beg]) != Character.toLowerCase(str[end]))
                    return false;

                beg++;
                end--;
            }
            
        }

        return true;
    }
}
