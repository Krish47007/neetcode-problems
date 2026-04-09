class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        beg,end = 0,n - 1
        ans = -1

        while beg <= end:
            mid = beg + (end - beg) //2;
            if nums[mid] == target:
                ans = mid
                break
            if nums[beg] <= nums[end]:
                if nums[mid] > target:
                    end = mid - 1
                else:
                    beg = mid + 1
            else:
                if nums[mid] >= nums[beg]:
                    if target >= nums[beg] and target < nums[mid]:
                        end = mid - 1
                    else:
                        beg = mid + 1
                else:
                    if target > nums[mid] and target <= nums[end]:
                        beg = mid + 1
                    else:
                        end = mid - 1
        
        return ans


        