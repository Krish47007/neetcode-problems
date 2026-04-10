class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int l = 0, r = 0;
        int[] ans = new int[n-k+1];

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        while( r < n)
        {
            //If the dq top has element < curr element in window
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[r])
                dq.removeLast();
            
            //Add it to dq
            dq.addLast(r);

            //Remove from beginning if window is shifted
            if( l > dq.getFirst())
                dq.pollFirst();
            
            //If we expand check if its stiil inside the window length
            if( r + 1 >= k)
            {
                ans[l] = nums[dq.getFirst()];
                //Shift the window
                l++;
            }
            //Exapnad the window
            r++;
        }

        return ans;
    }
}
