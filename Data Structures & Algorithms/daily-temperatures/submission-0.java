class Solution {

    class Pair
    {
        int temp;
        int idx;
        public Pair(int temp,int idx)
        {
            this.temp = temp;
            this.idx = idx;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        Stack<Pair> stk = new Stack<>();

        int[] res = new int[n];

        for(int i = n-1; i>=0 ;i--)
        {
            if(stk.isEmpty())
            {
                res[i] = 0;
            }
            else
            {
                while(!stk.isEmpty() && stk.peek().temp <= temperatures[i])
                {
                    stk.pop();
                }

                if(stk.isEmpty())
                    res[i] = 0;
                else
                {
                    Pair p = stk.peek();
                    res[i] = p.idx - i;
                }
            }

            stk.push(new Pair(temperatures[i],i));
        }

        return res;
        
    }
}
