class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        l,r = 0,0
        total,minLen = 0,float('inf')

        while r < n:
            total += nums[r]
            #If total >= target
            while l <= r and total >= target:
                minLen = min(minLen,r-l+1)
                total -= nums[l]
                l += 1
            
            r += 1
        
        return 0 if minLen == float('inf') else minLen