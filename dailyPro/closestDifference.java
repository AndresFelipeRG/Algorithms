import java.util.*;
class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int l = 0;
		int r = 0;
		int i = 0;
		int j = 0;
		int minDiff = Integer.MAX_VALUE;
		while(l < arrayOne.length && r < arrayTwo.length){
			 if(Math.abs(arrayOne[l]-arrayTwo[r]) < minDiff){
				  i = l;
				  j = r;
				  minDiff =  Math.abs(arrayOne[l]-arrayTwo[r]);
			 }
			 if(arrayOne[l] < arrayTwo[r]){
				 l+=1;
			 }
			 else{
				 r+= 1;
			 }
		}
		return new int []{arrayOne[i], arrayTwo[j]};
  }
}
