class Solution:
    def lengthOfLongestSubstring(self, arr: str) -> int:
        n = len(arr)
        l,r = 0,0
        mySet = set()
        maxLen = 0

        while r < n:
            if arr[r] in mySet:
                while l < r and arr[r] in mySet:
                    mySet.remove(arr[l])
                    l += 1
            mySet.add(arr[r])
            maxLen = max(maxLen,r-l+1)
            r += 1
        
        return maxLen