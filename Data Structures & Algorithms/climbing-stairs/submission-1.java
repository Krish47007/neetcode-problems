class Solution {

    private int calSteps(int n,Map<Integer,Integer> dp)
    {
        if( n <= 2)
            return dp.get(n);
        else if(dp.containsKey(n))
            return dp.get(n);
        else
        {
            int ans = calSteps(n-1, dp) + calSteps(n-2, dp);
            dp.put(n, ans);

            return ans;
        }
    }
    public int climbStairs(int n) {

        Map<Integer,Integer> dp = new HashMap<>();
        dp.put(1,1);
        dp.put(2,2);

        return calSteps(n,dp);
        
    }
}