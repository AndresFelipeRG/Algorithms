
class Solution {
    
  public boolean circularArrayLoop(int[] nums) {
       
       int n =  nums.length;
       int it = 0;

       for(int i = 0 ; i < n; i++){
           if(Math.abs(nums[i])>= (10001)) continue;
           it = i;
           int direction = nums[it] > 0 ? 1:-1;
           while(direction*nums[it] > 0){
               if(nums[it] == direction*(10001 + i)){
                   return true;
               }
               if(Math.abs(nums[it]) >= (10001)) break;
              
               int next = Math.floorMod(it + nums[it] , n);
               //System.out.println(next);
               if(next == it) {
                   nums[it] = direction*10001;
                   break;
               }
               nums[it] = direction*(10001 + i);
               it = next;
              
               
           }
       }
       return false;
    }
	
   
    
}
