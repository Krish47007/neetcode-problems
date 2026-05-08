class Solution:

    def getMaxFreq(self,freq):
        count = 0
        for i in range(len(freq)):
            count = max(count,freq[i])
        return count

    def characterReplacement(self, s: str, k: int) -> int:
        n = len(s)
        l,r = 0,0
        freq = [0] * 26
        ans = 0

        while r < n:
            ch = s[r]
            freq[ord(ch) - ord('A')] += 1
            #Check if window length - max freq of chars present 
            #in window > k then shrink
            while l <= r and (((r-l+1) - self.getMaxFreq(freq)) > k):
                freq[ord(s[l]) - ord('A')] -= 1
                l += 1
            #Take the max window length as ans
            ans = max(ans,r-l+1)
            r += 1
        
        return ans