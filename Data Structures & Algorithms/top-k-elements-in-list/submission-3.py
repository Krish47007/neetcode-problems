import heapq as h
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_map = {}
        n = len(nums)
        #Count frequency of each number
        for i in range(n):
            freq_map[nums[i]] = freq_map.get(nums[i],0) + 1
        
        min_heap = []

        for num,freq in freq_map.items():
            h.heappush(min_heap,(freq,num))
            #If size of heap > k
            if len(min_heap) > k:
                h.heappop(min_heap)
        
        #List comprehension and tuple unpacking
        return [num for freq,num in min_heap]

                
