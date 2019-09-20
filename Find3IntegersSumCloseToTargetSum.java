import java.lang.Integer.*;
import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int left = 0;
        int middle = left +1;
        int right = nums.length-1;
        int result = nums[left] + nums[middle] + nums[right];
        while(left < nums.length-2){
            int sum =nums[left] + nums[middle] + nums[right];
            if(Math.abs(target-sum) < diff){
                diff = Math.abs(target-sum);
                result = sum;
            }
            if(sum == target){
                return sum;
            }
            if(sum < target && middle < right){
                middle = middle + 1;
                right  = nums.length -1;
            }
            if(sum > target && middle < right ){
                right = right - 1;
            }
            if(middle == right){
                left++;
                middle = left + 1;
                right = nums.length -1;
            }
        }
        return result;
    }
}
