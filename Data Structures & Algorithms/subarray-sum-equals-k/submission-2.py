class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count, n = 0,len(nums)
        _map = {}
        total = 0

        for i in range(n):
            total += nums[i]
            if total == k:
                count += 1
            if total - k in _map:
                count += _map[total - k]
            
            _map[total] = _map.get(total,0) + 1
        
        return count

