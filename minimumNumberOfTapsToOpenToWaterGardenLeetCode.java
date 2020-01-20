import java.util.*;
class Solution {
    public int minTaps(int n, int[] ranges) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, n+10);
        dp[0] = 0;
        for(int i = 0; i <= n ;i++){
            for(int j = Math.max(0, i-ranges[i] + 1); j <= Math.min(n, i+ranges[i]);j++){
                dp[j] = Math.min(dp[j], dp[Math.max(i-ranges[i],0)] + 1);
            }
        }
        return dp[n] == n+10 ? -1: dp[n];
    }
}
