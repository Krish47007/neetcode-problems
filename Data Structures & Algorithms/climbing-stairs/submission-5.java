class Solution {

    private int rec(int n,Map<Integer,Integer> dp)
    {
        if(n <= 2)
        {
            return dp.get(n);
        }
        if(dp.containsKey(n))
            return dp.get(n);
            
        int ans = rec(n-1,dp) + rec(n-2,dp);
        dp.put(n,ans);
        return ans;
    }
    public int climbStairs(int n) {
        
        Map<Integer,Integer> dp = new HashMap<>();
        dp.put(1,1);
        dp.put(2,2);

        return rec(n,dp);
    }
}
