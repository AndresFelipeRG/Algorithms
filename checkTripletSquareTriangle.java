 import java.util.*;
public class JavaOnlineCompiler {

	public static void main(String args[]) {
        Squares cc = new Squares();
        int [] test = new int [] { 3, 5, 12, 5, 13};
        System.out.println(cc.squareTriangle(cc.squared(test)));
    }

}
		
		 
class Squares{

	public int [] squared(int [] input){
    	int [] res = new int [input.length];
      	for(int i =0 ; i < input.length; i ++){
        	res[i] = input[i]*input[i];
        }
        return res;
    }

	public boolean squareTriangle(int [] input) {
      	
        Arrays.sort(input);
       
        Set<Integer> s = new HashSet<>();
        for(int i: input){
        	s.add(i);
        }
        for(int i = 0; i < input.length; i++){
        	for(int j = i + 1; j < input.length; j++){
            	if(s.contains(input[i] + input[j])){
                   
                   return true;
                 }
            }
        }
      	
     	return false; 
    }
}
		
		
