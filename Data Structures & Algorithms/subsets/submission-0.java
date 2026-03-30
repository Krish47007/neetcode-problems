class Solution {

    private void rec(int i,int n,int[] nums,List<Integer> temp,List<List<Integer>> ans)
    {
        if(i == n)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }

        //Take
        temp.add(nums[i]);
        rec(i+1,n,nums,temp,ans);

        //Backtrack
        temp.removeLast();
        rec(i+1,n,nums,temp,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        rec(0,nums.length,nums,temp,ans);
        return ans;
        
    }
}
