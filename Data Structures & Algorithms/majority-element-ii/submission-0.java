class Solution {

    public List<Integer> majorityElement(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        for(int x : nums)
        {
            map.put(x,map.getOrDefault(x,0) + 1);
            
        }

        return map.keySet().stream().filter(key -> (map.get(key) > n/3))
                            //.map(key -> map.get(key))
                            .collect(Collectors.toList());

       
    }
}