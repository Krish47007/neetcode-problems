class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        n = len(nums)
        l,r = 0,0
        ans,zc = 0,0

        while r < n:
            if nums[r] == 0:
                zc += 1
            
            while l <= r and zc > 1:
                if nums[l] == 0:
                    zc -= 1
                l += 1
            
            ans = max(ans,r-l+1)
            r += 1
        
        return ans