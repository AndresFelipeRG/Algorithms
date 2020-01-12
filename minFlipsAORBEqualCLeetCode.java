class Solution {
    

    public int minFlips(int a, int b, int c) {
        
      
        int flips = 0;
        while(c > 0 || b > 0 || a > 0){
            
            int la = a & 1;
            int lb = b & 1;
            int lc = c & 1;
            if((lb | la) != lc && (lb & la) == 1) flips+=2;
            else if((lb | la) != lc && ( (lb | la) == 1 || (lb & la) == 0)) flips++;
            a >>= 1;
            b >>= 1;
            c >>= 1;
            
        }
        return flips;
        
    }
}
