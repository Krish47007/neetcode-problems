class Solution:

    def isPalindrome(self, s: str) -> bool:
        n = len(s)
        l,r = 0,n-1
        while l <= r:
            while l < n and not s[l].isalnum():
                l += 1
            while r >= 0 and not s[r].isalnum():
                r -= 1
            if l <= r and s[l].upper() != s[r].upper():
                return False
            
            l += 1
            r -= 1
        
        return True