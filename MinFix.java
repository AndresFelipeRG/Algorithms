//Array with heights should alternate and not adjacent of same value, find minimum of changes to array.
public class MinFix{
     
     public static int fix(int [] A){
         int count = 0;
         int i = 0;
         while(i < A.length-1){
              if(i < A.length -1){
                  if(A[i] == A[i+1]){
                      i = i + 2;
                      count = count + 1;
                      continue;
                  }
                
              }
              
              if(i < A.length -2){
                if(A[i]< A[i+1] && A[i+1] < A[i+2]){
                   count += 1;
                   i = i + 2;
                 }
                 else if(A[i] > A[i+1] && A[i+1] > A[i+2]){
                   count += 1;
                   i = i + 2;
                 }
                 else {
                     i = i+1;
                 }
              }
              else{
                i = i + 1;
              }
         }
         return count;
     }
    
     public static int solution(int [] test){
        int sol = 0;
        int i = 0;
        sol = fix(test);
        return sol;
     }
     public static void main(String []args){
        int [] test = new int[]{1,2,3,4,5,6};
        System.out.println(solution(test));
       
     }
}
