class Program {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    // Write your code here.
		
		if(array.length ==0){
			return 0;
		}
		if(array.length == 1){
			return array[0];
		}
		if(array.length == 2){
			return Math.max(array[0], array[1]);
		}
		int [] sol = new int[array.length];
		sol[0] = array[0];
		sol[1] = Math.max(array[0], array[1]);
		for(int i = 2; i < array.length;i++){
			sol[i] = Math.max(array[i] + sol[i-2], sol[i-1]);
		}
		
		return sol[array.length-1];
  }
}
