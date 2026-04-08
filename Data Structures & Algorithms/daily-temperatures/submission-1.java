class Solution {

    public int[] dailyTemperatures(int[] temp) {
        
        Stack<Integer> stk = new Stack<>();
        int n = temp.length;
        int[] res = new int[n];
        for(int i = n-1; i>= 0;i--)
        {
            if(stk.isEmpty())
            {
                res[i] = 0;
                stk.push(i);
            }
            else
            {
                while(!stk.isEmpty() && temp[stk.peek()] <= temp[i])
                    stk.pop();
                
                if(stk.isEmpty())
                    res[i] = 0;
                else
                    res[i] = stk.peek() - i;
                
                stk.push(i);
            }
        }

        return res;
    }
}