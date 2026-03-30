class Solution {

    private boolean canShip(int[] weights,int days,int cap)
    {
        int currentCap = cap;
        int ships = 1;
        for(int w : weights)
        {
            if(currentCap - w < 0)
            {
                ships++;
                if(ships > days)
                    return false;

                currentCap = cap;
            }

            currentCap -= w;
        }

        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        
        int low = weights[0];
        int n = weights.length;
        int high = 0;
        for(int i = 0;i<n;i++)
        {
            low = Math.max(low,weights[i]);
            high += weights[i];
        }
        int ans = high;
        while(low <= high)
        {
            int cap = low + (high - low)/2;

            if(canShip(weights,days,cap))
            {
                ans = Math.min(ans,cap);
                high = cap - 1;
            }
            else
            {
                low = cap + 1;
            }
        }

        return ans;
    }
}