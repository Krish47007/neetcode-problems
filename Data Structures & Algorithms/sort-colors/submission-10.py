class Solution:

    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        j,i,k = 0,0,n-1

        def swap(x,y):
            temp = nums[x]
            nums[x] = nums[y]
            nums[y] = temp

        while i <= k:
            if nums[i] == 0:
                swap(i,j)
                j += 1
            elif nums[i] == 2:
                swap(i,k)
                k -= 1
                i -= 1
            i += 1
