// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
   /* You start at index 0 in an array with length 'h'. At each step, you can move to the left, move to the right, or stay in the same place(Note! Stay in the same place also takes one step). How many possible ways are you still at index 0 after you have walked 'n' step*/
    public static  int recursive(int pos, int steps, int h, Map<ArrayList<Integer>, Integer> cache){
        
        if(pos < 0 || pos > h ){
            return 0;
        }
        if (pos == 0 && steps == 0){
            return 1;
        }
        if(steps == 0){
            return 0;
        }
        int count = 0;
        ArrayList<Integer> pairs = new ArrayList<>(Arrays.asList(pos, steps));
        if(cache.containsKey(pairs)){
            return cache.get(pairs);
        }
        count += recursive(pos, steps-1, h, cache );
        count += recursive(pos +1, steps-1, h, cache);
        count += recursive(pos -1, steps-1, h, cache);
        
        cache.put(pairs, count);
        return count;
       
    }
    public static int dpf(int pos, int steps, int h){
        
        int [][] dp = new int[h][steps+1];
        
        dp[0][1] = 1;
        dp[1][1] = 1;
        
        for(int j = 1; j < steps +1; j++){
            for(int i = 0; i < h; i++){
                dp[i][j] += dp[i][j-1] ;
                if(i != h -1){
                    dp[i][j] += dp[i+1][j-1];
                }
                if(i > 0){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
           
        }
        return dp[pos][steps];
        
    }
    public static void main(String[] args) {
        Map<ArrayList<Integer>, Integer> cache = new HashMap<>();
        System.out.println(recursive(3,4, 5,cache));
        System.out.println(dpf(3,4,5));
    }
}
