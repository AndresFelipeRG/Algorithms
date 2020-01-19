class Solution {
    
    public int maximum69Number (int num) {
        
       
        int ans = num;
        int cur = 0;
        for(int i = 0; i < (int)(Math.log10(num)+1); i++){
            int power = (int) Math.pow(10, i);
            int d = (num/(power))%10;
            int rest = cur + num - (num%(10*power));
            ans = d == 6 ? Math.max(ans, 9*power + rest) : Math.max(ans, 6*power + rest);
            cur+= d*(power);
            
        }
        return ans;
        
    }
}
