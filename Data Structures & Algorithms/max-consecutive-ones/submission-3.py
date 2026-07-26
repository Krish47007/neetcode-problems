class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        n = len(nums)
        maxCount,count = 0,0
        for i in range(n):
            if nums[i] == 1:
                count += 1
                maxCount = max(maxCount,count)
            else:
                count = 0
        
        return maxCount