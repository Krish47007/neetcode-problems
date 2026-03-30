class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        for(int x : nums)
            set.add(x);
        
        int ans = 0;

        for(int x : set)
        {
            if(!set.contains(x-1))
            {
                int length = 1;

                while(set.contains(x+length))
                    length++;
                
                ans = Math.max(ans,length);
            }
        }

        return ans;
    }
}
