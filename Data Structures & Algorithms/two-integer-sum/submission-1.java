class Solution {
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0;i<n;i++)
        {
            int diff = target - nums[i];
            if(map.containsKey(diff))
            {
                ans[0] = map.get(diff);
                ans[1] = i;
                break;
            }

            map.put(nums[i],i);
        }

        return ans;
    }
}
