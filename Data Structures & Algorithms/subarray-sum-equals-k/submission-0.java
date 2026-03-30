class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for(int i = 0;i<n;i++)
        {
            sum += nums[i];
            if(sum == k)
                count++;
            if(map.containsKey(sum-k))
                count += map.get(sum-k);
            
            //Put the sum and its count
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }

        return count;
    }
}