class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //Convert the array into Integer[] as sort takes Integer[] for comparator
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        int n = arr.length;
        int[] ans = new int[n];
        //Sort the array based on absolute value of x - a[i]
        Arrays.sort(nums,(a,b) -> {
            int diff = Integer.compare(Math.abs(x - a),Math.abs(x - b));
            if(diff == 0)
                return Integer.compare(a,b);
            return diff;
        });

        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<k;i++)
            res.add(nums[i]);
        
        //Answer should be in sorted order
        Collections.sort(res);
        return res;
    }
}