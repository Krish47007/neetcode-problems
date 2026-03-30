class Solution {

    private void getSumList(int[] nums,List<List<Integer>> ans)
    {
        int target = 0;
        int n = nums.length;

        for(int i = 0;i<n-2;i++)
        {
            if( i > 0 && nums[i] == nums[i-1])
                continue;
                
            int j = i+1, k = n-1;

            while(j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == target)
                {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));

                    j++;
                    k--;

                    //skip duplicates
                    while( j < n && nums[j] == nums[j-1])
                        j++;
                    while( k>= 0 && nums[k] == nums[k+1])
                        k--;
                }
                else if(sum > target)
                    k--;
                else
                    j++;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        getSumList(nums,ans);
        return ans;

    }
}
