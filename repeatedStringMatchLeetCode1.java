import java.util.*;

class Solution {
    
   
    public int repeatedStringMatch(String A, String B) {
        
        if(B.length() > A.length()){
            if(B.contains(A)){
                String temp = B.replaceAll(A,""); 
                if(temp.length() > 0){
                    int reps = (B.length()-temp.length())/A.length();
                    int i = B.indexOf(A);
                    String compare = B.substring(0, i) + A + B.substring(i + B.length()-temp.length());
                    //System.out.println(compare);
                    if((A+A).contains(compare)){
                        return reps+1;
                    }
                    if((A+A+A).contains(compare)){
                         return reps + 2;
                    } 
                  
                    return -1;
                }
                return B.length()/A.length() ;
            }
             if((A+A).contains(B)){
                        return 2;
            }
            return -1;
        }
        
        int count = 1;
        String temp = A;
        while(!temp.contains(B) && count++ <= 2 ){
            temp = temp + A;
        }
        return temp.contains(B) ? count: -1;
    }
}
