class Solution {

    public int calPoints(String[] operations) throws Exception{
        
        Stack<Integer> stk = new Stack<>();
        for(String op : operations)
        {
            if(op.equals("+"))
            {
                int x = stk.pop();
                int y = stk.pop();
                int res = x+y;
                stk.push(y);
                stk.push(x);
                stk.push(res);
            }
            else if(op.equals("D"))
            {
                int x = stk.peek();
                stk.push(2 * x);
            }
            else if(op.equals("C"))
            {
                stk.pop();
            }
            else
                stk.push(Integer.parseInt(op));
        }

        int sum = 0;
        for(int x : stk)
            sum +=x;
        
        return sum;
    }
}