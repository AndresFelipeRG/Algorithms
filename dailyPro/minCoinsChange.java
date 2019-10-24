import java.util.*;
class Program {
	public static int recursive(int n, int [] denoms, int m, int count){
		   if(n < 0 ){
				 return Integer.MAX_VALUE;
			 }
		   if(n == 0){
				  return count;
			 }
		   if( n > 0 && m <= 0){
				 return Integer.MAX_VALUE;
			 }
       return Math.min(recursive(n, denoms, m-1, count), recursive(n- denoms[m-1],denoms, m, count + 1));
	}
	public static int dp(int n, int [] denoms){
		  int size = denoms.length;
		  int [] sol = new int[n+1];
		  Arrays.fill(sol, Integer.MAX_VALUE);
		  sol[0] = 0;
		  for(int i = 0; i < size; i++){
				 for(int j = denoms[i]; j<= n; j++){
					  int temp= sol[j - denoms[i]] == Integer.MAX_VALUE? sol[j - denoms[i]]: 1+ sol[j - denoms[i]];
					  sol[j] = Math.min(sol[j],temp);
				 }
			}
		 return sol[n];
	}
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    // Write your code here.
		// int sol = recursive(n, denoms, denoms.length, 0);
		 int sol = dp(n, denoms);
		 return  sol == Integer.MAX_VALUE ? -1: sol;
  }
}
