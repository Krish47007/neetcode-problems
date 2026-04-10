class Solution:
    def mySqrt(self, x: int) -> int:
        low,high = 0, x;
        ans = 0;

        while low <= high:
            mid = low + (high - low) // 2
            square = mid * mid
            if square == x:
                ans = mid
                break
            elif square > x:
                high = mid - 1
            else:
                ans = mid
                low = mid + 1
        
        return ans


        