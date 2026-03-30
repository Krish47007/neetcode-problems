class Solution {

    private boolean canShip(int[] weights,int days,int cap)
    {
        int ships = 1;
        int currentCap = cap;
        for(int w : weights)
        {
            //Meaning one ship is full, current w can't be loaded
            if(currentCap - w < 0)
            {
                ships++;
                if(ships > days )
                    return false;
                //Restore current cap for next ship
                currentCap = cap;
            }
            //put current w in ship and reduce the current cap
            currentCap -= w;

        }

        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        int n = weights.length;

        for(int i = 0;i<n;i++)
        {
            low = Math.max(low,weights[i]);
            high += weights[i];
        }

        //So now we know that ship weight will be 
        // between low and high
        //we start from high and see if we get a better ans
        int res = high;
        while(low <= high)
        {
            int cap = low + (high - low)/2;
            //If the current capacity ship is able to ship all
            if(canShip(weights,days,cap))
            {
                res = Math.min(res,cap);
                high = cap - 1;
            }
            else
            {
                //Try to check for a ship with higher cap
                low = cap + 1;
            }

        }

        return res;
    }
}