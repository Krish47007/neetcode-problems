class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] A = nums1, B = nums2;
        int totalElements = A.length + B.length;
        //Total elements in the left partition
        int half =  totalElements / 2;

        //Make sure A is smaller sized array
        if(A.length > B.length)
        {
            int[] temp = A;
            A = B;
            B = temp;
        }

        //Now we need to run binary search on the smaller array A
        //l = 0 is min element we can take
        //r = A.length is the max element that we can take from A
        int l = 0, r = A.length;
        //Median exists so we can run until we find that so while (true)
        while(true)
        {
            //This is for A - i stands for number of elements taken from A
            int i = l + (r - l)/2;
            //This is for B - j stands for number of elements taken from B
            int j = half - i;

             // Edge handling
             //Last element of A from left portion
            int Aleft  = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;
            //Frist element of from right portion of A
            int Aright = (i < A.length) ? A[i] : Integer.MAX_VALUE;
            //Last element of B from left portion
            int Bleft  = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;
            //Frist element of from right portion of A
            int Bright = (j < B.length) ? B[j] : Integer.MAX_VALUE;

            //Check if correct partition
            if(Aleft <= Bright && Bleft <= Aright)
            {
                //Odd length
                if(totalElements % 2 != 0)
                {
                    return Math.min(Aright,Bright);
                }
                else
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;

            }
            else if (Aleft > Bright)
                r = i - 1;
            else
                l = i + 1;

        }
    }
}
