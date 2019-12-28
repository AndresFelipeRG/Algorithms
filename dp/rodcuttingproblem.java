// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
    
    public int rodcuttingProglem(int [] price, int [] length){
        int maxx = -1;
        //length is sorted asc 1...n
        int [] solution = new int[length.length+1];
        solution[0] = 0;
        int n = length.length;
        for(int i = 0; i < n; i++) solution[i] = price[i];
        for(int i = 1; i < n; i++){
            int maxx2 = -1;
            for(int j = 0; j < i; j++){
                maxx2 = Math.max(solution[j] + solution[i-(j)], maxx2);
                solution[i] = maxx2;
                maxx = Math.max(maxx2, maxx);
            }
        }
        
        return maxx;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
