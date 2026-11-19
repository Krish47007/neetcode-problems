class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ans = [] * 2
        _map = {}
        for i,n in enumerate(nums):
            if target - n in _map:
                ans.append(_map[target - n])
                ans.append(i)
                break
            _map[n] = i

        return ans