import java.util.*;
public class ShiftZerosEnd{

      public static int[] solution(int [] array){
         
         int k = 0;
         int l = 0;
         while(l < array.length){
             if(array[l] != 0){
                 array[k] = array[l];
                 k = k + 1;
             }
             l+= 1;
         }
         while(k < array.length){
             array[k] = 0;
             k+=1;
         }
         return array;
     }
     public static void main(String []args){
        System.out.println(Arrays.toString(solution(new int []{10000,0,0,0,0,0,1,2,3,4,5,0,0,0,4,0,0,3,1,0,0,0,0,0,100,30,23,0,0,12,0})));
     }
}
