class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        l,r = 0,n-1
        ans = []

        while l < r:
            total = nums[l] + nums[r]
            if total == target:
                ans.append(l+1)
                ans.append(r+1)
                return ans
            elif total > target:
                r -= 1
            else:
                l += 1