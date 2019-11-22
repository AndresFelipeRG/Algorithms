import java.util.*;

class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> sol = new ArrayList<>();
        if(nums.length == 0){ 
            
            if(upper != lower ) sol.add(String.valueOf(lower)+"->"+String.valueOf(upper));
            else sol.add(String.valueOf(lower));
            return sol;
        }
    
        if(nums.length == 1 && nums[0] == lower && lower == upper){
            return sol;
        }
        if(nums.length == 2 && nums[0] == lower && nums[1] == upper && lower+1 >= upper ){
            return sol;
        }
        if(nums[0] != lower){
               if(lower + 2 <= nums[0] ){
                    if(lower!= nums[0]-1) sol.add(String.valueOf(lower)+"->"+String.valueOf(nums[0]-1));
                   else sol.add(String.valueOf(lower));
                }
               else{
                    sol.add(String.valueOf(lower));
               }
        }
        for(int i = 0; i < nums.length; i++ ){
            
            if(i + 1 <= nums.length -1){
                if(nums[i]!=upper){
                if(nums[i+1] - 2 ==  nums[i]){
                    sol.add(String.valueOf(nums[i]+1));
                }
                else if(nums[i+1] > 2 + nums[i] ){
                    sol.add(String.valueOf(nums[i]+1)+"->"+String.valueOf(nums[i+1]-1));
                }
                }
            }else{
                if(nums[i]!=upper){
                if(upper >= 2  + nums[i]){
                    sol.add(String.valueOf(nums[i]+1)+"->"+String.valueOf(upper));
                }
                else if (upper == 1 + nums[i] ){
                    sol.add(String.valueOf(upper));
                }
                }
            }
            
        }
        if(sol.size()== 0 && upper != lower) sol.add(String.valueOf(upper));
        return sol;
        
    }
}
