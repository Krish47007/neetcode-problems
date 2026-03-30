class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        //Put all the elements in HashSet
        for(int x : nums)
            set.add(x);
        
        int ans = 0;

        for(int x : set)
        {
            int count = 0;
            int curr = x;
            //Start of the sequence 
            if(!set.contains(x-1))
            {
                //increment count as a new sequence is started
                count++;
                //Check if next element is present
                while(set.contains(curr + 1))
                {
                    count++;
                    curr++;
                }
            }

            ans = Math.max(ans,count);
        }

        return ans;
    }
}
