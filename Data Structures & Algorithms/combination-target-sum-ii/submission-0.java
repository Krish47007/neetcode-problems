class Solution {

    private void rec(int i,int n,int target,List<Integer> temp,List<List<Integer>> ans,int[] candidates)
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
        
        //Take
        temp.add(candidates[i]);
        rec(i+1,n,target - candidates[i],temp,ans,candidates);
        //Backtrack
        temp.removeLast();
        //Skip
        //When we are skipping the number we should skip all the occurrence of that number
        int j = i+1;
        while(j < n && candidates[j] == candidates[i])
            j++;
        //Now call for j
        rec(j,n,target,temp,ans,candidates);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //Sort the array
        Arrays.sort(candidates);
        rec(0,n,target,temp,ans,candidates);
        return ans;
    }
}
