class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;
        int me1 = 0, me2 = 0;
        int count1 = 0, count2 = 0;

        for(int x : nums)
        {
            if(me1 == x)
                count1++;
            else if(me2 == x)
                count2++;
            else if(count1 == 0)
            {
                me1 = x;
                count1 = 1;
            }
            else if(count2 == 0)
            {
                me2 = x;
                count2 = 1;
            }
            else
            {
                //A new element so decr. both the counts
                count1--;
                count2--;
            }
        }

        //Check if me1 and me2 both have fre > n/3
        count1 = count2 = 0;
        for(int x : nums)
        {
            if(x == me1)
                count1++;
            else if(x == me2)
                count2++;
        }

        List<Integer> ans = new ArrayList<>();
        if(count1 > n/3)
            ans.add(me1);
        if(count2 > n/3)
            ans.add(me2);

        return ans;
    }
}