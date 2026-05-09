class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        zeroCount,n = 0,len(nums)
        ans = 0
        l,r = 0,0
        for i in range(n):
            # Incr zero count
            if nums[i] == 0:
                zeroCount += 1
            # zero count is > 1, slide the window
            while l <= r and zeroCount > 1:
                if nums[l] == 0:
                    zeroCount -= 1
                l += 1
            # Take teh max window as ans
            ans = max(ans,r-l+1)
            r += 1
        
        return ans