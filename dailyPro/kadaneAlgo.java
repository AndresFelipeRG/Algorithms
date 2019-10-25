import java.util.*;
class Program {
  public static int kadanesAlgorithm(int[] array) {
    // Write your code here.
		int max = Integer.MIN_VALUE;
		int curr_sum = 0;
		for(int i = 0 ; i < array.length; i++){
			curr_sum = curr_sum + array[i];
			max = Math.max(curr_sum, max);
			if(curr_sum < 0){
				curr_sum = 0;
			}
		}
	  return max;
  }
}
