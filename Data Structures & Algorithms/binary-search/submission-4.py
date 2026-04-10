class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        beg,end = 0,n-1

        while beg <= end:
            mid = beg + (end - beg) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                end = mid - 1
            else:
                beg = mid + 1
        
        return -1