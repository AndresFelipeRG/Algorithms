 import java.util.*;
public class JavaOnlineCompiler {

	public static void main(String args[]) {
        Steps cc = new Steps();
     
        System.out.println(cc.steps(4));
    }

}
		
		 
class Steps{

	public int steps(int n){
    	if(n == 0){
           return 0;}
        if(n == 1){
           return 1;
        }
        if(n == 2){
        	return 2;
        }
        return steps(n-1) + steps(n-2);
    }
}
		
		
