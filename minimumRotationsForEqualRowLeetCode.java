import java.util.*;

class Solution {
    
    public int minDominoRotations(int[] A, int[] B) {
        
        Integer min = Integer.MAX_VALUE;
        
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapAD = new HashMap<>();
        
        Map<Integer, Integer> mapB = new HashMap<>();
        Map<Integer, Integer> mapBD = new HashMap<>();
        int diff = 0;
        for(int i = 0; i < A.length; i++) {
            
            if(A[i] != B[i]){
            diff++;
            if(mapA.containsKey(A[i])){ mapA.put(A[i], mapA.get(A[i])+1);}
            else{ mapA.put(A[i], 1);}
            
            if(mapB.containsKey(B[i])){ mapB.put(B[i], mapB.get(B[i])+1);}
            else { mapB.put(B[i], 1);}
            }
            
            if(mapAD.containsKey(A[i])){ mapAD.put(A[i], mapAD.get(A[i])+1);}
            else{ mapAD.put(A[i], 1);}
            
            if(mapBD.containsKey(B[i])){ mapBD.put(B[i], mapBD.get(B[i])+1);}
            else { mapBD.put(B[i], 1);}
            
        }
      
        if(mapAD.keySet().size() == 1 || mapBD.keySet().size() == 1) return 0;
      
        System.out.println(String.valueOf(mapA));
        System.out.println(String.valueOf(mapB));
        for(Map.Entry<Integer, Integer> entry:  mapA.entrySet()){
            if(mapB.containsKey(entry.getKey())){
                int total = entry.getValue() + mapB.get(entry.getKey());
                if ( total == diff ){
                    
                     if(entry.getValue() < mapB.get(entry.getKey())) {
                         if(mapBD.get(entry.getKey()) + entry.getValue() == A.length){
                             min = Math.min(min, entry.getValue() );
                         }
                     }
                     else{
                         if(mapAD.get(entry.getKey()) + mapB.get(entry.getKey()) == A.length) {
                             min = Math.min(min, mapB.get(entry.getKey()));
                         }
                     }
                     
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1: min;
    }
}
