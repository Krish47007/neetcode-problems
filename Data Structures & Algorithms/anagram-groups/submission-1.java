class Solution {

    private int getHash(String str)
    {
        int sum = 0;
        for(char ch : str.toCharArray())
        {
            sum += (int)ch;
        }

        return sum;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(String s : strs)
        {
            char[] arr = s.toCharArray();
            //Sort the array
            Arrays.sort(arr);
            String temp = new String(arr);

            if(map.containsKey(temp))
            {
                map.get(temp).add(s);
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(temp,list);
            }
        }

        map.values().forEach(list -> ans.add(list));

        return ans;


    }
}
