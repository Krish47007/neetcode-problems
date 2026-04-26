class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set()
        n = len(nums)
        total_length = 0

        for i in range(n):
            num_set.add(nums[i])
        
        for num in num_set:
            if num - 1 not in num_set:
                #start of the sequence
                length = 1
                while num + length in num_set:
                    length += 1
                #Take the max of sequences
                total_length = max(length,total_length)
            
        return total_length