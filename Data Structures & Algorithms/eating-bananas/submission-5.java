class Solution {

    private boolean canFinish(int[] piles,int k,int hour)
    {
        int totalHours = 0;

        for(int p : piles)
        {
            totalHours += Math.ceil((double)p/k);
            if(totalHours > hour)
                return false;
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1, high = Integer.MIN_VALUE;
        for(int p : piles)
        {
            high = Math.max(high,p);
        }

        int ans = high;

        while(low <= high)
        {
            int k = low + (high - low)/2;

            if(canFinish(piles,k,h))
            {
                ans = Math.min(ans,k);
                high = k - 1;
            }
            else
                low = k + 1;
        }

        return ans;
    }
}
