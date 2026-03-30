class Solution {

    private boolean sameDir(int x,int y)
    {
        return (x > 0 && y > 0) || (x < 0 && y < 0);
    }
    public int[] asteroidCollision(int[] ast) {
        
        int n = ast.length;
        Stack<Integer> stk = new Stack<>();

        for(int i = 0;i<n;i++)
        {
            //If TOS +ve no problem
            //If TOS -ve still ok due to relative position the 
            //will move to opposite direction but not collide so add it on TOS
            if(ast[i] > 0)
                stk.push(ast[i]);
            else
            {
                //-ve astroid
                boolean destroyed = false;

                while(!stk.isEmpty() && stk.peek() > 0)
                {
                    if(stk.peek() < Math.abs(ast[i]))
                    {
                        //top destroyed
                        stk.pop();
                    }
                    else if(stk.peek() == Math.abs(ast[i]))
                    {
                        //both destroyed
                        stk.pop();
                        destroyed = true;
                        break;
                    }
                    else
                    {
                        //If TOS > ast[i]
                        destroyed = true;
                        break;
                    }
                }

                if(!destroyed)
                    stk.push(ast[i]);
            }
        }

        int[] ans = new int[stk.size()];
        int idx = 0;

        for(int val : stk)
        {
            ans[idx++] = val;
        }

        return ans;
    }
}