class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int n = nums.length;
        int l = 0, r = 0;

        Set<Integer> set = new HashSet<>();

        while( r < n)
        {
            while( l <= r && r-l > k)
            {
                set.remove(nums[l]);
                l++;
            }

            boolean added = set.add(nums[r]);
            if(!added)
                return true;

            r++;
        }
        return false;
    }
}