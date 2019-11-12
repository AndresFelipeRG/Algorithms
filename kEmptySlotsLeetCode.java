import java.util.*;
class Solution {
    public int kEmptySlots(int[] bulbs, int K) {
        TreeSet<Integer> set = new TreeSet();
        int day = 0;
        for(int b : bulbs){
            day++;
            set.add(b);
            Integer l = set.lower(b);
            Integer r = set.higher(b);
            if(l!=null && b-l -1 == K || r != null && r-b -1 == K){
                return day;
            }
        }
        return -1;
    }
}
