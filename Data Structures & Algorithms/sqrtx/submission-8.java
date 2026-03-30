class Solution {
    public int mySqrt(int x) {
        
        int beg = 1, end = x;
        int ans = 0;
        while(beg <= end)
        {
            int mid = beg + (end - beg)/2;
            long square = (long)mid * mid;

            if(square == x)
                return mid;
            else if(square > x)
                end = mid - 1;
            else
            {
                ans = mid;
                beg = mid + 1;
            }
        }

        return ans;
    }
}