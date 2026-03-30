class Solution {

    private void rec(int open,int closed,String curr,List<String> ans)
    {
        if(open > closed)
            return;
        if(open == 0 && closed == 0)
        {
            ans.add(curr);
            return;
        }

        if(open > 0)
            rec(open-1,closed,curr + "(",ans);
        rec(open,closed-1,curr + ")",ans);
    }
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        int open = n, closed = n;
        rec(open,closed,"",ans);
        return ans;
    }
}
