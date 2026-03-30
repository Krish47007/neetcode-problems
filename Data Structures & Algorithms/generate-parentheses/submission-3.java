class Solution {

    private void rec(int open,int closed,StringBuilder curr,List<String> ans)
    {

        if(open == 0 && closed == 0)
        {
            ans.add(curr.toString());
            return;
        }
       
       if(open > closed)
            return;

        if(open > 0)
        {
            curr.append("(");
            rec(open-1,closed,curr,ans);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(closed > 0)
        {
            curr.append(")");
            rec(open,closed-1,curr,ans);
            curr.deleteCharAt(curr.length() - 1);
        }        
             
    }
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        int open = n, closed = n;
        StringBuilder sb = new StringBuilder();
        rec(open,closed,sb,ans);
        return ans;
    }
}
