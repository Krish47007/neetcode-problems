class Solution {

    private void rec(int i,int n,List<Integer> temp,List<List<Integer>> ans,int[] nums,int target)
    {
        if(target < 0)
            return;
        
        if(target == 0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i == n)
        {
            return;
        }

        //Take and stay at same index
        temp.add(nums[i]);
        rec(i,n,temp,ans,nums,target - nums[i]);
        temp.remove(temp.size() - 1);
        rec(i+1,n,temp,ans,nums,target);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        rec(0,nums.length,temp,ans,nums,target);
        return ans;
    }
}
