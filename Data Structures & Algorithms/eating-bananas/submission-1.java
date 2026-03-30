class Solution {

    private boolean canFinish(int[] piles,int k,int hours)
    {
        int totalHours = 0;

        for(int p : piles)
        {
            totalHours += (p + k - 1)/k;
            if(totalHours > hours)
                return false;
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1; //Koko can't eat less than 1 banana/min
        int high = 0; //max banana/min is the max(piles)

        for(int p : piles)
        {
            high = Math.max(high,p);
        }

        //Initially lets assume high as the ans as banana eating speed.
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
