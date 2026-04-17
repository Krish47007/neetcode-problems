class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n = len(nums)
        me,count = 0,0

        for i in range(n):
            if count == 0:
                me = nums[i]
                count = 1
            else:
                if me != nums[i]:
                    count -=1
                else:
                    count += 1
        return me