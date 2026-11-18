class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        max_sum,sum = float('-inf'),0

        for n in nums:
            sum += n
            max_sum = max(sum,max_sum)
            #Reset sum
            if sum < 0:
                sum = 0
        
        return max_sum
