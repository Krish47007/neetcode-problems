class Solution {
    public int mySqrt(int x) {
        
        int beg = 0, end = x;
        int ans = -1;
        while(beg <= end)
        {
            int mid = beg + (end - beg)/2;
            long square = (long)mid * mid;

            if(square == x)
            {
                ans = mid;
                break;
            }
            else if(square < x)
            {
                ans = mid;
                beg = mid + 1;
            }
            else
                end = mid - 1;
        }

        return ans;
    }
}