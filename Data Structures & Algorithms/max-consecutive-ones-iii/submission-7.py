class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        zeroCount,n = 0,len(nums)
        l,r = 0,0
        ans = 0

        while r < n:
            if nums[r] == 0:
                zeroCount += 1
            #Check if zeroCount is > k then slide the widnow
            while l <= r and zeroCount > k:
                if nums[l] == 0:
                    zeroCount -= 1
                l += 1
            #Take the max as ans
            ans = max(ans,r-l+1)
            r += 1
        
        return ans
                
            