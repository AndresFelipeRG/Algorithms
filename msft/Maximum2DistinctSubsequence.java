 import java.util.*;
public class Maximum2DistinctSubsequence {

	public static void main(String args[]) {
        ChildClass cc = new ChildClass();
        int [] input = new int[]{1};
        System.out.println(cc.solution(input));
    }

}
		
		 
class ChildClass {

	
	public int solution(int [] sequence) {
     	int solution = 0;
      	Set<Integer> set = new HashSet<>();
        int l =0;
        int last = 0;
        int lastNumCount = 0;
        int length = 0;
        for(int i=0; i< sequence.length; i++){
          
           if(set.contains(sequence[i])){
             	if( last == sequence[i]){
                	lastNumCount += 1;
                    
                }else{
                	last = sequence[i];
                    lastNumCount = 1;
                }
                length += 1;
                solution = Math.max(solution, length);
           }
          else{
         
           if(set.size() == 2){
           		
              set = new HashSet<>();
              set.add(last);
              set.add(sequence[i]);
              last = sequence[i];
              solution = Math.max(solution, length);
              length = lastNumCount + 1;
              lastNumCount = 1;
              
           }else{
              set.add(sequence[i]);
              length+=1;
              solution = Math.max(solution, length);
          	}
          }
           
        }   
      	return solution;
    }
}
		
		
