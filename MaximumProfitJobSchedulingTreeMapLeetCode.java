import java.util.*;
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int [][] jobs = new int[endTime.length][3];
        for(int i = 0; i < endTime.length; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a,b)-> a[1]-b[1]);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        
        for(int [] job: jobs){
            int currProfit =  map.floorEntry(job[0]).getValue() + job[2];
            if(currProfit > map.lastEntry().getValue()){
                map.put(job[1], currProfit);
            }
        }
        return map.lastEntry().getValue();
    }
}
