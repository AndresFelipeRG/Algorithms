import java.util.*;

class Solution {
    
    public int check(int t, int[] A, int[] B){
        
        int minA = 0;
        int minB = 0;
        
        for(int i = 0; i < A.length; i++){
            
            if(A[i] != t && B[i] != t) return -1;
            
            if(B[i] != t) minB++;
            
            if(A[i] != t) minA++;
            
        }
        return Math.min(minA, minB);
    }
    public int minDominoRotations(int[] A, int[] B) {
        
        int res = check(A[0], A, B);
        if( res != -1|| A[0] == B[0]) return res;
        return check(B[0], A, B);
        
    }
}
