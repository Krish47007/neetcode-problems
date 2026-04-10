import math

class Solution:
    
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        low,high = 1,max(piles)
        ans = high
        while low <= high:
            k = low + (high - low) // 2

            def canFinish() -> bool:
                totalHours = 0
                for p in piles:
                    totalHours += math.ceil(p/k)
                    if totalHours > h:
                        return False
                return True
            
            if canFinish():
                ans = k
                high = k - 1
            else:
                low = k + 1
        
        return ans


        