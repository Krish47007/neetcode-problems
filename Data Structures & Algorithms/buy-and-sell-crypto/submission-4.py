class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #Assume we are buying on first day itself
        buy,maxProfit = prices[0],0
        #Iterate the array from 1st index
        for i in range(1,len(prices),1):
            #Assuming the future prices are higher than buy price
            profit = prices[i] - buy 
            maxProfit = max(maxProfit,profit)
            if prices[i] < buy:
                buy = prices[i]
        
        return maxProfit