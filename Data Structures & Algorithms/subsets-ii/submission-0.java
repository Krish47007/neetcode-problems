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

        //Skip - when skipping a number skip all its occurrence otherwise 
        //it will be picked up in next function call
        int j = i+1;
        while( j < n && nums[j] == nums[i])
            j++;

        rec(j,n,temp,ans,nums);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        Arrays.sort(nums);

        rec(0,n,temp,ans,nums);

        return ans;
    }
}
