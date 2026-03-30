class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        int n = people.length;
        int beg = 0, end = n-1;
        int count = 0;

        while(beg <= end)
        {
            int totalWeight = people[beg] + people[end];

            if(totalWeight > limit)
            {
                //allocate the boat for heavy person
                count++;
                end--;
            }
            else {
                //totalWeight is <= limit
                count++;
                beg++;
                end--;
            }
        }

        return count;
    }
}