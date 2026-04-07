class Solution {
    public String simplifyPath(String s) {
        
        String[] paths = s.split("/");
        Stack<String> stk = new Stack<>();

        for(int i = 0; i < paths.length;i++)
        {
            if(!stk.isEmpty() && !paths[i].isEmpty() && paths[i].equals(".."))
                stk.pop();
            else if(!paths[i].isEmpty() && !paths[i].equals(".") && !paths[i].equals(".."))
                stk.push(paths[i]);
        }

        if(stk.isEmpty())
            return "/";

        StringBuilder ans = new StringBuilder();

        for(String x : stk)
        {
            ans.append("/");
            ans.append(x);
        }

        return ans.toString();
    }
}