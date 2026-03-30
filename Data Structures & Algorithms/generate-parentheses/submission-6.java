class Solution {

    private void rec(int open,int closed,StringBuilder temp,List<String> ans)
    {
        if(open < 0 || closed < 0 || open > closed)
            return;
        
        if(open == 0 && closed == 0)
        {
            ans.add(temp.toString());
            return;
        }
        //Take open
        temp.append("(");
        rec(open-1,closed,temp,ans);
        //Backtrack
        temp.deleteCharAt(temp.length() - 1);
        //Take closed
        temp.append(")");
        rec(open,closed - 1,temp,ans);
        //Backtrack
        temp.deleteCharAt(temp.length() - 1);
    }
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        int open = n, closed = n;
        StringBuilder temp = new StringBuilder();

        rec(open,closed,temp,ans);

        return ans;
    }
}
