class Solution {
    
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l < r){
            int middle = l + (r-l)/2;
            if(middle + 1 < n && nums[middle] < nums[middle + 1]) l = middle + 1;
            else r = middle;
        }
        return l;
    }
}
