class Solution {

    private int[] buildPrefix(int[] arr)
    {
        int n = arr.length;
        int[] pf = new int[n];
        pf[0] = arr[0];

        for(int i = 1;i<n;i++)
        {
            pf[i] = Math.max(pf[i-1],arr[i]);
        }

        return pf;
    }

    private int[] buildSuffix(int[] arr)
    {
        int n = arr.length;
        int[] sf = new int[n];
        sf[n-1] = arr[n-1];

        for(int i = n-2;i >= 0;i--)
        {
            sf[i] = Math.max(sf[i+1],arr[i]);
        }

        return sf;
    }
    public int trap(int[] height) {

        int n = height.length;

        int[] leftMax = buildPrefix(height);
        int[] rightMax = buildSuffix(height);

        int totalWater = 0;

        for(int i = 0;i<height.length;i++)
        {
            int waterStored = Math.min(leftMax[i],rightMax[i]) - height[i];
            if(waterStored > 0)
                totalWater += waterStored;

        }

        return totalWater;

        
    }
}
