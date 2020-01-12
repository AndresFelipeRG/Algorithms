class Solution {
    
    public int[] getNoZeroIntegers(int n) {
        
        
        outer: for(int i = 1; i < n; i++){
            
            int res = n - i;
            int ic = i;
            int resc = res;
            while(res > 0 ){
                if(res % 10 == 0) continue outer;
                res /= 10;
            }
            while(ic > 0){
                if(ic % 10 == 0) continue outer;
                ic /= 10;
            }
            
            return new int [] { i, resc};
            
        }
        return new int []{};
    }
}
