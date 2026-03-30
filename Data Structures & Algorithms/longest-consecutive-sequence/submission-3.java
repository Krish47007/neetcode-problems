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
            //A number is the start of a sequence if num - 1 is not in the set.
            //This guarantees that each consecutive sequence is counted exactly once.
            if(!set.contains(x-1))
            {
                int length = 1;
                //Check if next element is present
                while(set.contains(x + length))
                {
                    //Increment length
                    length++;
                }
                //Take the max
                ans = Math.max(ans,length);
            }
            
        }

        return ans;
    }
}
