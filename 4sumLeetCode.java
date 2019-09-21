import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            
            for(int j = i +1; j < nums.length; j++){
                int left = j + 1;
                int right = nums.length -1;
                while(left < right){
                    int sum = nums[i]+ nums[j] +  nums[left]+ nums[right] ;
                    if(sum == target){
                        
                        
                        set.add( Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left += 1;
                        right -= 1;
                    }
                    else if(sum < target){
                        left +=1;
                    }
                    else{
                        right = right -1;
                    }
                }
            }
        }
        Iterator<List<Integer>> it = set.iterator();
        while(it.hasNext()){
            result.add(it.next());
        }
        return result;
    }
}
