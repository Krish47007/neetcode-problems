class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int idx = 0;
        int n = arr.length;

        for(int i = 1;i<n;i++)
        {
            //Check if current element is more closer to x
            if(Math.abs(x - arr[i]) < Math.abs(x - arr[idx]))
                idx = i;
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(arr[idx]);

        int l = idx - 1, r = idx + 1;

        while(ans.size() < k)
        {
            if( l >= 0 && r < n)
            {
                if(Math.abs(x - arr[l]) <= Math.abs(x - arr[r]))
                    ans.add(arr[l--]);
                else
                    ans.add(arr[r++]);
            }
            else if( l >= 0) //One pointer can cross either of the boundaries
                ans.add(arr[l--]);
            else if ( r < n)
                ans.add(arr[r++]);
        }

        //Sort the ans
        ans.sort(Comparator.naturalOrder());

        return ans;
    }
}