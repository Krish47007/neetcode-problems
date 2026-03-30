class Solution {

    private void rec(int i,int n,int target,List<Integer> temp,List<List<Integer>> ans,int[] nums)
    {
        if(target < 0)
            return;
        if(target == 0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i == n)
            return;
        
        //Take and stay at same index
        temp.add(nums[i]);
        rec(i,n,target-nums[i],temp,ans,nums);
        //Bactrack
        temp.removeLast();
        //Skip and move to next index
        rec(i+1,n,target,temp,ans,nums);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        rec(0,n,target,temp,ans,nums);
        return ans;
    }
}
