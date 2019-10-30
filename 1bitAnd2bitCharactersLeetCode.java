class Solution {
    public boolean isOneBitCharacter(int[] bits) {
       
        int n = bits.length;
        if(n == 1){
            return true;
        }
        if(bits[n-1] == 1 && bits[n-2] == 1){
            return false;
        }
        if(bits[n-1] == 0 && bits[n-2] == 0){
            return true;
        }
        int i = 0;
        while( i < bits.length){
            if(i == bits.length -1 && bits[i] == 0){
                return true;
            }
            
            if(bits[i] == 0){
                i = i + 1;
            }
            else{
                i = i + 2;
            }
            
        }
        return false;
    }
}
