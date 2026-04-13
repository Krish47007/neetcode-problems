class Solution:

    '''
         +ve number starts from 1 and in an array of size n max upto n we can store.
        If our array size is n and even if we store all the numbers from 1 to n
        then in worst case missing +ve is n+1.
        Ex -  arr = [1,2,3] , n = 3 so first missing is n + 1 = 4
    '''
    def firstMissingPositive(self, nums: List[int]) -> int:
        mySet = set()
        n = len(nums);
        # Add the numbser in Set
        for i in range(n):
            mySet.add(nums[i])
        
        # Now check from num 1 to n
        for i in range(1,n + 1):
            # If i is not present in set then its first missing +ve
            if i not in mySet:
                return i
        
        # If all the nums from 1 to n are there in nums
        return n+1
        