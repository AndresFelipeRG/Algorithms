import java.util.*;
public class FindMaxWhichHasNegativeValue{

     public int  answer(int [] arr){
         
         Set<Integer> set = new HashSet<>();
         int res = -1;
         for(int el: arr){
            
            if(set.contains(el)){
                
                res = Math.max(res, Math.abs(el));
            }
            set.add(-el);
             
         }
         return res;
     }
     
}
