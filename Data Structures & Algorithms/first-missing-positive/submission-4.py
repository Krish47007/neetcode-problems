class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        
        n = len(nums)
        # Mark all -ve numbers as 0
        for i in range(n):
            if nums[i] < 0:
                nums[i] = 0
        
        #Scan through the array and mark the numbers that exist in array
        # to its -ve counterpart
        for i in range(n):
            temp = abs(nums[i])
            if 1 <= temp <= n:
                if nums[temp - 1] > 0:
                   nums[temp - 1] *= -1  # If its +ve then make it -ve
                elif nums[temp - 1] == 0:  # if its 0 then replace with -(n+1)
                     nums[temp - 1] = -1 * ( n + 1)
                #Already -ve numbers we dont touch
        
        #Scan from 1 to n and see if it exists
        for i in range(1,n+1):
            if nums[i-1] >= 0:
                return i #first missing +ve
        
        # all the numbers from 1 to n exists in array so next missing is n+1
        return n+1