class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int [] sol = new int[nums.length];
        sol[0] = nums[0];
        sol[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            sol[i] = Math.max(nums[i] + sol[i-2], sol[i-1]);
        }
        return sol[nums.length-1];
    }
}
