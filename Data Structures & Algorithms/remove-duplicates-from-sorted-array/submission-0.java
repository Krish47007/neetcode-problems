class Solution {
    public int removeDuplicates(int[] nums) {
        
        int n = nums.length;
        // l denotes where to place the next unique element
        // r actually scan the array
        int l = 0, r = 0;

        while( r < n)
        {
            nums[l] = nums[r];
            //Skip duplicates
            while( r < n && nums[r] == nums[l])
                r++;
            //Move l so that next unique lement can be placed
            l++;
        }

        return l;
    }
}