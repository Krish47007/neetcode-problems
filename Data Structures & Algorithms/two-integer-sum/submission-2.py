class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ans = []
        _map = {}
        n = len(nums)

        for i in range(n):
            diff = target - nums[i]
            if diff in _map:
                ans.append(_map[diff])
                ans.append(i)
                break
            _map[nums[i]] = i
        
        return ans