class Solution:
    def twoSum(self, num: List[int], target: int) -> List[int]:
        
        beg,end = 0,len(num) - 1
        while beg < end:
            sum = num[beg] + num[end]
            if sum == target:
                return [beg + 1, end + 1]
            elif sum > target:
                end -= 1
            else:
                beg += 1
