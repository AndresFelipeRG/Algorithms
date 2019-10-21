public class HelloWorld{
      
     public static int minSequence(int [] arr, int target){
         int sol = arr.length + 1;
         int left = 0;
         int right = -1;
         int curr = 0;
         while(left < arr.length && right + 1 < arr.length){
             if(curr < target ){
                 
                 right +=1;
                 curr += arr[right];
                 
             }
             else{
                 curr-= arr[left];
                 left+= 1;
             }
             if(curr == target){
                 System.out.println("left:"+left+"right:"+right);
                 if(right-left + 1  == 1){
                     return 1;
                 }else{
                   sol = Math.min(sol, right-left+1 );
                   left += 1;
                 }
                
             }
         }
         if(sol == arr.length -1){
             return 0;
         }
         return sol;
     }
     public static void main(String []args){
        System.out.println(minSequence(new int []{2,3,1,3,2,4,3}, 7));
     }
}
