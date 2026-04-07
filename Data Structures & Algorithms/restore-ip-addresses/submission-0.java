class Solution {

    private void rec(int i,int dots,int n,String currIP,String s,List<String> ans)
    {
        if(dots == 4 && i == n)
        {
            ans.add(currIP.substring(0,currIP.length() - 1));
            return;
        }
        if(dots > 4)
            return;
        
        // we need to check max of 3 chars from i but it may go out of bounds
        // so take min
        // i represents the start pos of numbers and 
        //j represents how many chars from i we have taken (max 3 chars allowed)
        for(int j = i; j < Math.min(i+3,n); j++)
        {
            //a two or 3 digit num can't have leading 0
            //But single 0 is allowed
             if(i != j && s.charAt(i) == '0')
                continue;
            
            String num = s.substring(i,j+1);
            //we need to consider numbers < 256
            if(Integer.parseInt(num) < 256)
            {
                //Check for next segment of ip
                rec(j+1,dots + 1, n, currIP + num + ".",s,ans);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        
        List<String> ans = new ArrayList<>();
        if(s.length() > 12)
            return ans;
        
        rec(0,0,s.length(),"",s,ans);

        return ans;
    }
}