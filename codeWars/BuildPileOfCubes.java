public class ASum {
	
	public static long findNb(long m) {
		// your code
     long cubes = 1;
     long v = 0;
     while(v < m) {v += (cubes*cubes*cubes); cubes+=1;}
     return v==m ? cubes-1:-1;
	}	
}
