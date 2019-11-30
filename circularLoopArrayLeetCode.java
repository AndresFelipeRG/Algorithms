
class Solution {
    
    public boolean circularArrayLoop(int[] nums) {
     
        int n = nums.length;
        for(int i = 0; i < n ;i++){
             int count = 0;
             int it = i;
             int start = i;
             int direction = nums[it] > 0 ? 1 : -1;
             while( direction*nums[it] > 0){
                 
                 it = Math.floorMod(nums[it]+it,n);
                 count++;
                 if(it == start && count > 1) return true;
                 if((count >= n)||( start == it && count == 1)){
                     break;
                 }
                 
             }
           
        }
        
      
        
        return false;
        
    }
    
    
}
