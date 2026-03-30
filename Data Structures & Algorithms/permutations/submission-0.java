class Solution {

    private void rec(int n,List<Integer> temp,List<List<Integer>> ans,boolean[] picked,int[] nums)
    {
        if(temp.size() == n)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0;i<n;i++)
        {
            //If not picked in this path
            if(!picked[i])
            {
                //Take
                temp.add(nums[i]);
                picked[i] = true;
                rec(n,temp,ans,picked,nums);
                //Backtrack
                temp.removeLast();
                picked[i] = false;                
                //skipping current element happens when loop increments current
                //so no need of skip recursion call.
                //Call recusrively only when we take an element.
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        boolean[] picked = new boolean[n];

        rec(n,temp,ans,picked,nums);

        return ans;
    }
}
