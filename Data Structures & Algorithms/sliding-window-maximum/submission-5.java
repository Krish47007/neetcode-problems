class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int l = 0, r = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];

        while( r < n)
        {
            //if top of dq is less than curr then no point in 
            //keeping in dq as they will never become max
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[r])
                dq.removeLast();
            
            dq.addLast(r);

            if( l > dq.getFirst())
                dq.removeFirst();
            
            if( ( r + 1) >= k)
            {
                ans[l] = nums[dq.getFirst()];
                l++;
            }
            r++;
        }

        return ans;
    }
}
