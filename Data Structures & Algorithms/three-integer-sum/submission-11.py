class Solution:
    
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        nums.sort()
        ans = []
        n = len(nums)

        for i in range(n-2):
            #Skip duplicates
            if i > 0 and nums[i] == nums[i-1]:
                continue

            j,k = i + 1, n - 1

            while j < k :
                total = nums[i] + nums[j] + nums[k]
                if total == 0:
                    ans.append([nums[i],nums[j],nums[k]])
                    j += 1
                    k -= 1
                    # skip duplicates
                    while j < k and nums[j] == nums[j-1]:
                        j += 1
                    # skip duplicates
                    while k > j and nums[k] == nums[k+1]:
                        k -= 1
                elif total > 0:
                    k -= 1
                else:
                    j += 1
        
        return ans
