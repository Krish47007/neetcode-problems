class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int profit = 0;
        
        int l = 0, r = 1;

        while( r < n)
        {
            if(prices[l] < prices[r])
            {
                //Take the profit
                profit = Math.max(profit,prices[r] - prices[l]);
                
            }
            else
            {
                //Buy on today
                l = r;
            }
            //Check if in future we get better profit
            r++;
        }

        return profit;
    }
}
