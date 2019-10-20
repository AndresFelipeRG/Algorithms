import java.util.*;
class Solution {
    
   
    public int minMoves2(int[] nums) {
        
        Arrays.sort(nums);
        
        int moves = 0;
        int medium = nums[nums.length/2];
        for(int i = 0; i <  nums.length; i++){
            moves += Math.abs(medium - nums[i]);
        }
        return moves;
    }
}
