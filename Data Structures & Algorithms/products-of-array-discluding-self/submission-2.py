class Solution:
    def buildPref(self,nums):
        n = len(nums)
        pref = [0] * n
        pref[0] = nums[0]

        for i in range(1,n):
            pref[i] = pref[i-1] * nums[i]
        
        return pref

    def buildSuff(self,nums):
        n = len(nums)
        suff = [0] * n
        suff[n-1] = nums[n-1]

        for i in range(n-2,-1,-1):
            suff[i] = suff[i+1] * nums[i]
        
        return suff


    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        ans = [0] * n
        pref = self.buildPref(nums)
        suff = self.buildSuff(nums)

        for i in range(n):
            if i == 0:
                ans[i] = suff[i+1]
            elif i == n-1:
                ans[i] = pref[i-1]
            else:
                ans[i] = pref[i-1] * suff[i+1]

        return ans
