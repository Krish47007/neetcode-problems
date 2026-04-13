class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int l = 0;
        for(int r = 0;r<n;r++)
        {
            if(r - l + 1 > k + 1)
            {
                set.remove(nums[l]);
                l++;
            }

            if(set.contains(nums[r]))
                return true;
            
            set.add(nums[r]);
        }

        return false;
    }
}