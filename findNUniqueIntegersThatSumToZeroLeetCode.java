class Solution {
    
    public int[] sumZero(int n) {
        if (n == 1) return new int [] {0};
        if (n == 2) return new int [] {-1,1};
        if (n == 3) return new int [] {-1, 0, 1};
        int i = 1;
        int [] ans = new int[n];
        if(n%2 != 0){
            for(i = 1; i < n-3; i+=2){
                ans[i] = (i);
                ans[i-1] = -(i);
            }
            i--;
            ans[i] = i;
            ans[i+1] = i+1;
            ans[i+2] = -(2*i+1);
        }else{
            for(i = 1; i < n; i+=2){
                ans[i] = (i);
                ans[i-1] = -(i);
            }
        }
        return ans;
    }
}
