class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        //Sort the array
        Arrays.sort(nums);

        for(int i = 0;i<n-2;i++)
        {
            if(nums[i] > 0)
                break;
            
            //Skip duplicates
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            int j = i+1, k = n-1;

            while( j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0)
                {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;

                    //Skip duplicates
                    while( j < n && nums[j] == nums[j-1])
                        j++;
                    //Skip duplicates
                    while(k > 0 && nums[k] == nums[k+1])
                        k--;
                    
                }
                else if(sum > 0)
                    k--;
                else
                    j++;
            }
        }

        return ans;
        
    }
}
