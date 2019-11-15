import java.util.*;

class Solution {
    
    
    public int oddEvenJumps(int[] A) {
        
        
        int n = A.length;
        if(n<=1){return n;}
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        boolean [] odd = new boolean[n];
        boolean [] even = new boolean[n];
     
        odd[n-1] = true;
        even[n-1] = true;
        map.put(A[n-1], n-1);
        
        for(int i = n - 2; i >= 0; i--){
            int v = A[i];
            if(map.containsKey(A[i])){
                even[i] = odd[map.get(v)];
                odd[i] = even[map.get(v)];
            }
            else{
                
               Integer lower = map.lowerKey(v);
               Integer higher = map.higherKey(v);
                
               if(higher != null){
                    odd[i] = even[map.get(higher)];
               }
                if(lower != null){
                    even[i] = odd[map.get(lower)];
                }
                
            }
            map.put(v, i);
        }
        
        int res  = 0;
        for(boolean b: odd ){
            if (b) res++;
        }
        return res;
    }
}
