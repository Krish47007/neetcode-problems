class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        _map = {}
        n = len(nums)
        ans = [] * 2

        for i in range(n):
            if target - nums[i] in _map:
                ans.append(_map[target-nums[i]])
                ans.append(i)
                break
            else:
                _map[nums[i]] = i
        
        return ans