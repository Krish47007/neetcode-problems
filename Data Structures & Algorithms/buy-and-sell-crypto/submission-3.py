class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = profit = 0
        n = len(prices)
        buy_price = prices[0]

        for i in range(1,n):
            profit = prices[i] - buy_price
            max_profit = max(max_profit,profit)
            #Better buying opportunity
            if prices[i] < buy_price:
                buy_price = prices[i]
        
        return max_profit