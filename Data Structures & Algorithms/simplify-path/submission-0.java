class Solution {
    public String simplifyPath(String path) {
        
        String[] str = path.split("/");
        Stack<String> stk = new Stack<>();

        for(int i = 0;i<str.length;i++)
        {
            if(!stk.isEmpty() && !str[i].isEmpty() && str[i].equals(".."))
                stk.pop();
            else if(!str[i].isEmpty() && !str[i].equals(".") && !str[i].equals(".."))
                stk.push(str[i]);
        }

        if(stk.isEmpty())
            return "/";
        
        StringBuilder ans = new StringBuilder();
        for(String dir : stk)
        {
            ans.append("/");
            ans.append(dir);
        }

        return ans.toString();
    }
}