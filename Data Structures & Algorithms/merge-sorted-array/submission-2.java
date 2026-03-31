class Solution {

    public void merge(int[] nums1, int n, int[] nums2, int m) {
        
        int i = n-1, j = m-1;
        int p = n + m - 1;

        while( i >= 0 && j >= 0)
        {
            if(nums1[i] >= nums2[j])
                nums1[p--] = nums1[i--];
            else
                nums1[p--] = nums2[j--];
        }

        //We dont need to check nums1 as its already sorted so all elements of nums1 are 
        //in their correct pos
        // but if nums1 is exhausted and nums2 still remains so in that case we need to check
        // E.g, nums1 = [4,5,6,0,0,0] and nums2 = [1,2,3]

        while(j >= 0)
        {
            nums1[p--] = nums2[j--];
        }
    }
}