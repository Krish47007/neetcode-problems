class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        freqMap = {}
        l,r = 0,0
        ans = 0

        while r < n:
            #Add the current char's freq in map
            freqMap[s[r]] = freqMap.get(s[r],0) + 1
            #If freq is > 1
            while l <= r and freqMap[s[r]] > 1:
                freqMap[s[l]] -= 1
                if freqMap[s[l]] == 0:
                    freqMap.pop(s[l])
                l += 1
            
            ans = max(ans,r-l+1)
            r += 1
        
        return ans
