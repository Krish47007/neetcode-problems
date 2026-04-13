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
        for i in range(n):
            mySet.add(nums[i])
        
        for i in range(1,n + 1):
            if i not in mySet:
                return i
        
        return n+1
        