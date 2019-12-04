import java.util.*;


class Solution {
    
    public int threeSumSmaller(int[] nums, int target) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int qte = 0;
       // System.out.println(Arrays.toString(nums));
        for(int i = 0; i < n; i++){
           
            int l = i + 1;
            int r = n - 1;
            while(l < r ){
                int cur = nums[i] + nums[l] + nums[r];
                //System.out.println(cur);
                if(cur >= target){
                   
                    r = r - 1; 
                }
                else if(cur < target){ 
                    
                    qte += (r-l);
                    l++;
                }
                
                }
               
            }
        
        return qte;
    }
}
