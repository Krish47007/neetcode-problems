class Solution {

private boolean isPalindrome(char[] str,int left,int right)
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
        int left = 0, right = s.length()-1;
        boolean ans = true;

        while(left < right)
        {
            if(str[left] != str[right]){

                ans =  isPalindrome(str,left + 1,right) || isPalindrome(str,left,right - 1);
                break;
            }
            left++;
            right--;
        }

        return ans;
    }
}