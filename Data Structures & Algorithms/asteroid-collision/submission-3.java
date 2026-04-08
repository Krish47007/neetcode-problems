class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        
        int n = asteroids.length;
        Stack<Integer> stk = new Stack<>();

        for(int i = 0;i<n;i++)
        {
            if(asteroids[i] < 0)
            {
                boolean destroyed = false;
                while(!stk.isEmpty() && stk.peek() > 0)
                {
                    if(stk.peek() < Math.abs(asteroids[i]))
                    {
                        stk.pop();
                    }
                    else if(stk.peek() == Math.abs(asteroids[i]) )
                    {
                        stk.pop();
                        destroyed = true;
                        break;
                    }
                    else
                    {
                        destroyed = true;
                        break;
                    }

                }

                if(!destroyed)
                    stk.push(asteroids[i]);
                
            }
            else
                stk.push(asteroids[i]);
        }
        int[] res = new int[stk.size()];
        int k = 0;
        for(int x : stk)
            res[k++] = x;

        return res;
    }
}