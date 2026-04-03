class Solution {

    private int[] buildPfProd(int[] nums)
    {   
        int n = nums.length;
        int[] pf = new int[n];
        pf[0] = nums[0];

        for(int i = 1;i < n;i++)
        {
            pf[i] = pf[i-1] * nums[i];
        }

        return pf;

    }

    private int[] buildSfProd(int[] nums)
    {   
        int n = nums.length;
        int[] sf = new int[n];
        sf[n-1] = nums[n-1];

        for(int i = n-2;i >= 0;i--)
        {
            sf[i] = sf[i+1] * nums[i];
        }

        return sf;

    }

    public int[] productExceptSelf(int[] nums) {
        
        int[] pf = buildPfProd(nums);
        int[] sf = buildSfProd(nums);
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0;i<n;i++)
        {
            if(i == 0)
                ans[i] = sf[i+1];
            else if(i == n-1)
                ans[i] = pf[i-1];
            else
                ans[i] = pf[i-1] * sf[i+1];

        }

        return ans;
    }
}  
