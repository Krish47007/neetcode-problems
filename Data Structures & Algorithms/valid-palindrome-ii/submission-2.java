class Solution {

    private boolean checkPali(char[] str,int left,int right)
    {
        while(left < right)
        {
            if(str[left] != str[right])
                return false;
            left++;
            right--;
        }

        return true;
    }
    public boolean validPalindrome(String s) {
        
        char[] str = s.toCharArray();
        int beg = 0, end = s.length() - 1;

        boolean ans = true;

        while(beg < end)
        {
            if(str[beg] != str[end])
            {
                //1st mismatch
                ans = checkPali(str,beg + 1, end) || checkPali(str,beg,end-1);
                break;
            }
            beg++;
            end--;
        }

        return ans;
    }
}