import java.util.*;
class Program {
	public static int recursive(int n, int m, int [] denoms){
		if(n ==  0){
			return 1;
		}
		if(n < 0){
			return 0;
		}
		if(m <= 0 && n > 0){
			return 0;
		}
		else{
			return recursive(n, m-1, denoms)  + recursive(n-denoms[m-1], m, denoms);
		}
	}
	public static int dp(int n, int[] denoms){
		 int size = denoms.length ;
		 int [] table = new int[n+1];
		 Arrays.fill(table, 0);
		 table[0] = 1;
		 for(int i = 0 ; i < size ;i++){
			for(int j = denoms[i]; j <= n; j ++ ){
		 		table[j] = table[j] + table[j-denoms[i]];
		 	}
		 }
		 return table[n];
	}
  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    // Write your code here.
		 //return recursive(n, denoms.length, denoms);
		 return dp(n, denoms);
  }
}
