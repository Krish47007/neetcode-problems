class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int l = 0,r = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];

        while( r < n)
        {
            //Keep checking if top of dq is < curr
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[r])
                dq.pollLast();
            
            dq.addLast(r);

            if( l > dq.getFirst())
                dq.removeFirst();
            
            if(r+1 >= k)
            {
                ans[l] = nums[dq.getFirst()];
                l++;
            }

            r++;
        }

        return ans;
    }
}
