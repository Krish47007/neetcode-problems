class Solution {

    private int binSearch(int[] nums,int beg,int end,int target)
    {
        if(beg > end)
            return -1;
        
        int mid = beg + (end - beg)/2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target)
            return binSearch(nums,beg,mid - 1,target);
        else
            return binSearch(nums,mid + 1,end,target);
    }
    public int search(int[] nums, int target) {
        
        return binSearch(nums,0,nums.length-1,target);
    }
}