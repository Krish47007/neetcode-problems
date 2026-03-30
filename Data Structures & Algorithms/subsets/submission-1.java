class Solution {

    private void rec(int i,int n,List<Integer> temp,List<List<Integer>> ans,int[] nums)
    {
        if(i == n)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        //Take
        temp.add(nums[i]);
        rec(i+1,n,temp,ans,nums);
        //Backtrack
        temp.removeLast();
        //Skip
        rec(i+1,n,temp,ans,nums);

    }
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;

        rec(0,n,temp,ans,nums);

        return ans;
    }
}
