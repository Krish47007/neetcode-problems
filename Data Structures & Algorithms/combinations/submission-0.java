class Solution {

    private void rec(int i,int n,int k,List<Integer> temp,List<List<Integer>> ans)
    {
        if(k == 0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i == n)
            return;
        
        //Take
        temp.add(i+1);
        rec(i+1,n,k-1,temp,ans);
        //backtrack
        temp.removeLast();
        rec(i+1,n,k,temp,ans);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        rec(0,n,k,temp,ans);

        return ans;
    }
}