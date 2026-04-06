class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int profit = 0;
        //Lets say we buy at 1st day assuming its the min price
        int minSoFar = prices[0];

        for(int i = 1;i<n;i++)
        {
            //Try to sell and see if the profit is more.
            profit = Math.max(profit, prices[i] - minSoFar);
            //if the current stock price is less than our previous price then we buy
            //so update our minSoFar
            if(prices[i] < minSoFar)
                minSoFar = prices[i];
        }

        return profit;
    }
}
