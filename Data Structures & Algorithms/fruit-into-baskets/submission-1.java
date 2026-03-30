class Solution {
    public int totalFruit(int[] fruits) {
        
        Map<Integer,Integer> basket = new HashMap<>();
        int l = 0, r = 0;
        int n = fruits.length;
        int ans = 0;
        while(r < n)
        {
            int f = fruits[r];
            basket.put(f,basket.getOrDefault(f,0) + 1);

            while(l <= r && basket.size() > 2)
            {
                int count = basket.get(fruits[l]);
                count--;
                if(count == 0)
                    basket.remove(fruits[l]);
                else
                    basket.put(fruits[l],count);
                l++;
            }

            int len = r-l+1;
            ans = Math.max(ans,len);
            r++;
        }

        return ans;
    }
}