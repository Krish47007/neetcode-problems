class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        beg,end = 0, n - 1
        minNum = float('inf')

        if n == 1:
            return nums[0]

        while beg <= end:
            if nums[beg] <= nums[end]:
                minNum = min(minNum,nums[beg])
                break
            else:
                mid = beg + (end - beg)//2
                minNum = min(minNum,nums[mid])
                
                if nums[mid] >= nums[beg]:
                    beg = mid + 1
                else:
                    end = mid - 1

        return minNum
        