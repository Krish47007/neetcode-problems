/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        int beg = 1, end = n;

        while(beg <= end)
        {
            int pick = beg + (end - beg)/2;
            int retVal = guess(pick);

            if( retVal == 0)
                return pick;
            else if(retVal == 1)
                beg = pick + 1;
            else
                end = pick - 1;
        }

        return -1;
    }
}