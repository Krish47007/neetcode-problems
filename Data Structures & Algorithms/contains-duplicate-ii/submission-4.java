class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int n = nums.length;
        //Stores a number and the last index where it occurred
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<n;i++)
        {
            //If its a duplicate and index is in range
            if(map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k)
                return true;
            
            //Put in map the current element and its index
            map.put(nums[i],i);
        }

        return false;
    }
}