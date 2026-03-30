class Solution {

    private int totalXOR = 0;

    private void rec(int i,int n,int xor,int[] nums)
    {
        if( i == n)
        {
            this.totalXOR += xor;
            return;
        }

        //Take
        rec(i+1,n,xor ^ nums[i], nums);

        //Skip
        rec(i+1,n,xor,nums);
    }
    public int subsetXORSum(int[] nums) {

        this.totalXOR = 0;
        int n = nums.length;
        int xor = 0;

        rec(0,n,xor,nums);
        
        return this.totalXOR;
    }
}