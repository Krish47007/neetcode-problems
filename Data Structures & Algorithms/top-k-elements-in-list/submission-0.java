class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        
        //Count the frquency of each number
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums)
        {
            map.put(n,map.getOrDefault(n,0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        //Iterate the map and put num,freq in list
        map.forEach((num,freq) -> list.add(new int[]{num,freq}));

        //Sort the array based on non-increasing order of frequency
        list.sort((a,b) -> Integer.compare(b[1],a[1]));

        //Add the k most frequent element
        int[] ans = new int[k];

        for(int i = 0;i<k;i++)
        {
            ans[i] = list.get(i)[0];
        }

        return ans;
    }
}
