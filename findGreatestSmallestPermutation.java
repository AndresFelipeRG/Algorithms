// "static void main" must be defined in a public class.
import java.util.Arrays;

public class Main {
    
    public static int [] findGreatestSmallestPermutation(int [] A){
        
        int j = -1, n = A.length;
        for(int i = n-2; i>= 0; i--){
            if(A[i] > A[i+1]) {
                j = i;
                break;
            }
        }
        if(j == -1) return A;
        int k = j + 1;
        
        for(int i = j + 1; i < n; i++){
            if(A[i] > A[k] && A[i] < A[j]){
                k = i;
                }
        }
        int temp = A[j];
        A[j] = A[k];
        A[k] = temp;
        return A;
        
    }
    public static void main(String[] args) {
        int [] arrA = {1, 7, 3, 4, 5};
        System.out.println(Arrays.toString(findGreatestSmallestPermutation(arrA)));
    }
}
