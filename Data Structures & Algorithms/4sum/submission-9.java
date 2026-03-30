class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0;i<n-3;i++)
        {
            if( i > 0 && nums[i] == nums[i-1])
                continue;
            
            for(int j = i+1;j<n-2;j++)
            {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                
                int x = j+1, y = n-1;

                while(x < y)
                {
                    long sum = (long)nums[i] + nums[j] + nums[x] + nums[y];
                    if(sum == target)
                    {
                        ans.add(Arrays.asList(nums[i],nums[j],nums[x],nums[y]));
                        x++;
                        y--;
                        
                        //skip duplicates
                        while( x < y && nums[x] == nums[x-1])
                            x++;
                        
                        while(y > x && nums[y] == nums[y+1])
                            y--;

                    }
                    else if(sum > target)
                    {
                        y--;
                    }
                    else
                    {
                        x++;
                    }
                }
            }
        }

        return ans;
    }
}