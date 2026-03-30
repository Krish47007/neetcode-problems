class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs)
        {
            char[] arr = s.toCharArray();
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

        return new ArrayList<>(map.values());
    }
}
