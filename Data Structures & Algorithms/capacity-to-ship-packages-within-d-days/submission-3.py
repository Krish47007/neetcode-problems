class Solution:

    def canShip(self,weights: List[int],cap: int, totalShips: int) -> boolean:

        shipCount,currentCap = 1,cap
        for i in range(0,len(weights)):
            if currentCap - weights[i] < 0:
                shipCount += 1
                if shipCount > totalShips:
                    return False
                currentCap = cap
            currentCap -= weights[i]
        
        return True

    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low,high,n = float('-inf'),0,len(weights)

        for i in range(0,n):
            low = max(low,weights[i])
            high += weights[i]
        
        ans = high

        while low <= high:
            cap = low + (high - low) // 2
            if self.canShip(weights,cap,days):
                ans = min(ans,cap)
                high = cap - 1
            else:
                low = cap + 1

        return ans