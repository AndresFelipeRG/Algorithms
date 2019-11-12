import java.util.*;
class Solution {
    public int kEmptySlots(int[] bulbs, int K) {
        int [] days = new int[bulbs.length];
        for(int i = 0; i < bulbs.length; i++){
            days[bulbs[i]-1] = i + 1;
        }
        
        int l = 0;
        int r = K + 1;
        int ans = Integer.MAX_VALUE;
        search: while(r < days.length){
            for(int i = l+1; i < r; i++){
                if(days[i] < days[l] || days[i] < days[r]){
                    l = i;
                    r = i + K + 1;
                    continue search;
                }
            }
            ans = Math.min(ans, Math.max(days[l], days[r]));
            l = r;
            r = l + K + 1;
        }
        return ans < Integer.MAX_VALUE ? ans: -1;
    }
}
