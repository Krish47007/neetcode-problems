class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int sum = 0;
        Map<Integer,Integer> freqMap = new HashMap<>();
        int count = 0;

        for(int i = 0;i<n;i++)
        {
            sum += nums[i];
            if(sum == k)
                count++;
            if(freqMap.containsKey(sum-k))
                count += freqMap.get(sum-k);
            
            //Put the sum and its count
            freqMap.put(sum,freqMap.getOrDefault(sum,0) + 1);
        }

        return count;
    }
}