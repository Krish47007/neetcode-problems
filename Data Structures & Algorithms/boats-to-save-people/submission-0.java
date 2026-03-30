class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        int count = 0;
        int beg = 0, end = people.length - 1;

        while(beg <= end)
        {
            int weight = people[beg] + people[end];

            if(weight > limit)
            {
                count++;
                end--;
            }
            else if(weight <= limit)
            {
                count++;
                beg++;
                end--;
            }
        }

        return count;

    }
}