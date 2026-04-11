class Solution {

    private int[] merge(int[] nums1,int nums2[])
    {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[n + m];

        int i = 0, j = 0, k = 0;

        while(i < n && j < m)
        {
            if(nums1[i] <= nums2[j])
                res[k++] = nums1[i++];
            else
            {
                res[k++] = nums2[j++];
            }
        }

        while( i < n)
            res[k++] = nums1[i++];
        
        while(j < m)
            res[k++] = nums2[j++];

        return res;

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        
        int[] res = merge(nums1,nums2);
        int n = res.length;
        if(n % 2 != 0)
        {
            return ((double)(res[n/2]));
        }
        else
        {
            int x = res[n/2], y = res[(n/2) - 1];
            return ((double)x + y) / 2;
        }

    }
}
