import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> dups = new HashMap<>();
        for(int number: nums){
            if(map.containsKey(number)){
                map.put(number, map.get(number)+1);
            }
            else{
                map.put(number, 1);
                dups.put(number, new HashMap<Integer, Integer>());
            }
        }
       
        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                
                    int sum = nums[i] + nums[j];
                    
                    if(map.containsKey(-sum)){
                       
                        if(nums[i] == -sum || nums[j] == -sum){
                            if(map.get(-sum) < 2){
                                continue;
                            }
                        }
                        if (nums[i] == -sum && nums[j] == -sum){
                             if(map.get(-sum) < 3){
                                continue;
                            }
                        }
                        if(dups.containsKey(nums[i])){
                            if(dups.get(nums[i]).containsKey(nums[j])){
                                if(dups.get(nums[i]).get(nums[j]) == -sum){
                                    continue;
                                }
                            }
                            else if(dups.get(nums[i]).containsKey(-sum)){
                                if(dups.get(nums[i]).get(-sum) == nums[j]){
                                    continue;
                                }
                            }
                        }
                        else if(dups.containsKey(nums[j])){
                            if(dups.get(nums[j]).containsKey(nums[i])){
                                if(dups.get(nums[j]).get(nums[i]) == -sum){
                                    continue;
                                }
                            }
                            else if(dups.get(nums[j]).containsKey(-sum)){
                                if(dups.get(nums[j]).get(-sum) == nums[i]){
                                    continue;
                                }
                            }
                        }
                        else if(dups.containsKey(-sum)){
                            if(dups.get(-sum).containsKey(nums[i])){
                                if(dups.get(-sum).get(nums[i]) == nums[j]){
                                    continue;
                                }
                            }
                            else if(dups.get(-sum).containsKey(nums[j])){
                                if(dups.get(-sum).get(nums[j]) == nums[i]){
                                    continue;
                                }
                            }
                        }
                       
                        List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], -sum));
                        result.add(triplet);
                        
                        dups.get(nums[i]).put(nums[j], -sum);
                        dups.get(nums[i]).put(-sum, nums[j]);
                        
                        dups.get(nums[j]).put(nums[i], -sum);
                        dups.get(nums[j]).put(-sum, nums[i]);
                        
                        dups.get(-sum).put(nums[i], nums[j]);
                        dups.get(-sum).put(nums[j], nums[i]);
                    
                    }
                
            }
        }
        return result;
    }
}
