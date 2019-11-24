import java.util.*;

class Solution {
    
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length <= 1) return intervals;
        ArrayList< ArrayList<Integer> > res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
       
        int l = intervals[0][0];
        int prev = intervals[0][1];
        
        for(int i = 1; i < intervals.length;i++){
            
            if(intervals[i][0] <= prev){
                
                int r = Math.max(prev, intervals[i][1]);
                prev = r;
            }
            else{
                res.add(new ArrayList<>(Arrays.asList(l,prev)));
                l = intervals[i][0];
                prev = intervals[i][1];
                
            }
         }
        
         res.add(new ArrayList<>(Arrays.asList(l,prev)));
         int [][] ans = new int[res.size()][2];
         for(int i = 0; i < res.size() ;i++){
             ans[i][0] = res.get(i).get(0);
             ans[i][1] = res.get(i).get(1);
         }
         return ans;
        
    }
}
