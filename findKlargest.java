import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        if(nums.length == 0) return -1;
        int curr = nums[0];
        int ans = nums[0];
        for(int i = 0; i < nums.length; i++){
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            if(nums[i] > curr){
                curr = nums[i];
            }
        }
      
        while(k > 0){
            if(counts.containsKey(curr)){
            if(counts.get(curr) >= k){
                return curr;
            }else{
                k-= counts.get(curr);
                curr--;
            }}
            else {
                curr--;
            }
        }
        return ans;
    }
}
