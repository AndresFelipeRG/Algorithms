// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
    
    public static int maxVolume(int [] array){
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE+1;
        int maxA = Integer.MIN_VALUE+2;
        int maxB = Integer.MIN_VALUE+1;
        int maxC = Integer.MIN_VALUE;
        
        int vol = 0;
        for(int e: array){
            
            if(e > maxA){
                int temp = maxA;
                maxA = e;
                maxC = maxB;
                maxB = temp;
            }
            else if(e > maxB){
                maxC = maxB;
                maxB = e; 
            }
            else if( e > maxC){
                maxC = e;
            }
            
            if( e < minA){
                minB = minA;
                minA = e;
            }
            else if( e < minB){
                minB = e;
            }
        }
        System.out.println(maxA +" "+ maxB +" " + maxC);
        System.out.println(minA +" "+ minB );
        return minA*minB*maxA > maxA*maxB*maxC? minA*minB*maxA : maxA*maxB*maxC;
    }
    public static void main(String[] args) {
        System.out.println(maxVolume(new int[]{-10,-11,1,23,4,100}));
    }
}
