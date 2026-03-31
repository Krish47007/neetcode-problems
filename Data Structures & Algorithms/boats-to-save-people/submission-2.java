class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        //Sort the array in acsending order of weights of people
        Arrays.sort(people);
        int beg = 0, end = people.length - 1;
        int boats = 0;

        while(beg <= end)
        {
            int weight = people[beg] + people[end];
            if(weight <= limit)
            {
                //Pair a light and heavy person
                boats++;
                beg++;
                end--;
            }
            else
            {
                //Give a boat to the heavy person
                boats++;
                end--;
            }
        }

        return boats;
    }
}