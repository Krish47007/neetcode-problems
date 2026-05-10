class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        l,r = 0,0
        total,ans = 0,float('inf')

        while r < n:
            total += nums[r]
            #Try to get a better ans as long as the window sum >= target
            while l <= r and total >= target:
                ans = min(ans,r-l+1)
                total -= nums[l]
                l += 1
            
            r += 1
        
        return 0 if ans == float('inf') else ans
