import java.util.*;
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int [startTime.length][3];
        for(int i = 0; i < startTime.length; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1]-b[1]);
        List<Integer> maxProfit = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();
        maxProfit.add(0);
        endTimes.add(0);
        
        for(int i = 0; i < startTime.length; i++){
            int lastIndex = Collections.binarySearch(endTimes, jobs[i][0] + 1);
            if(lastIndex < 0){
                lastIndex = -(lastIndex)- 1;
            }
            lastIndex--;
            int currProfit = maxProfit.get(lastIndex) + jobs[i][2];
            if(currProfit > maxProfit.get(maxProfit.size() - 1)){
                maxProfit.add(currProfit);
                endTimes.add(jobs[i][1]);
            }
        }
        return maxProfit.get(maxProfit.size() -1);
    }
}
