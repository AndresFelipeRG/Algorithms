import java.util.*; 


class Solution {
    public int[] plusOne(int[] digits) {
        
        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            
            int temp = digits[i];
            digits[i] = (digits[i] + carry)% 10;
            
            carry = temp == 9 && carry == 1 ? 1: 0;
            
        }
        if(carry == 1) {
            int res[] = new int[digits.length +  1];
            res[0] = carry;
            for(int i = 0; i < digits.length; i++){
                res[i+1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}
