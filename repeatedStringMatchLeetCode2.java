import java.util.*;

class Solution {
    
   public int repeatedStringMatch(String A, String B) {
        int reps = 1;
        StringBuilder S = new StringBuilder(A);
        for(; S.length() < B.length();reps++ ) S.append(A);
        if( S.indexOf(B) >= 0) return reps;
        if( S.append(A).indexOf(B) >= 0) return ++reps;
        return -1;
    }
   
}
