class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        _set = set()
        n = len(nums)
        total_length = 0

        for i in range(n):
            _set.add(nums[i])
        
        for i in range(n):
            if nums[i] - 1 not in _set:
                #start of the sequence
                length = 1
                while nums[i] + length in _set:
                    length += 1
                #Take the max of sequences
                total_length = max(length,total_length)
            
        return total_length