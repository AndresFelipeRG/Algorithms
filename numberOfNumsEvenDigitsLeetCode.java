
class Solution {
    
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int n: nums){
            if(n!= 0 && (int)(Math.log10(n) + 1) % 2 == 0) ans++;
        }
        return ans;
    }
}
