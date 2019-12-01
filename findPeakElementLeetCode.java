class Solution {
    
    public int findPeakElement(int [] nums, int l, int r){
        
        if(r < l ) return -1;
        int middle = l+(r-l)/2;
        
        if( middle < nums.length -1 && middle > 0 && (nums[middle] > nums[middle+1] && nums[middle] > nums[middle-1]) ) return middle;
        if(middle == 0 && nums[0] > nums[1]) return 0;
        if(middle == nums.length-1 && nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        int ansR = findPeakElement(nums, middle+1, r);
        if(ansR >= 0) return ansR;
        int ansL = findPeakElement(nums, l, middle-1);
        if(ansL >= 0) return ansL;
        return -1;
    
    }
    
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        return findPeakElement(nums, 0, nums.length-1);
    }
}
