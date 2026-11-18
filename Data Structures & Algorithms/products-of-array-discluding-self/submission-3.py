class Solution:

    def buildPref(self,nums: List[int]) -> List[int]:
        n = len(nums)
        pf = [ 0 ] * n
        pf[0] = nums[0]
        for i in range(1,n):
            pf[i] = pf[i-1] * nums[i]

        return pf
    
    def buildSuff(self,nums: List[int]) -> List[int]:
        n = len(nums)
        sf = [0] * n
        sf[n-1] = nums[n-1]
        for i in range(n-2,0,-1):
            sf[i] = nums[i] * sf[i+1]
        
        return sf

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0] * n
        pf = self.buildPref(nums)
        sf = self.buildSuff(nums)

        for i in range(n):
            if i == 0:
                ans[i] = sf[i+1]
            elif i == n-1:
                ans[i] = pf[i-1]
            else:
                ans[i] = pf[i-1] * sf[i+1]
        
        return ans
