import java.util.*;
class Solution {
    /*
    You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only. Your task is to make these two strings equal to each other. You can swap any two characters that belong to different strings, which means: swap s1[i] and s2[j].

Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so.*/
   
    public int minimumSwap(String s1, String s2) {
        if(s1.length() != s2.length()){
            return -1;
        }
        int x1 = 0;
        int x2 = 0;
        
        int y1 = 0;
        int y2 = 0;
        for(int i = 0; i < s1.length(); i++){
            
            if(s1.charAt(i)!= s2.charAt(i)){
                if(s1.charAt(i) == 'x'){
                    x1++;
                }
                else{
                    y1++;
                }
                if(s2.charAt(i) == 'x'){
                    x2++;
                }
                else{
                    y2++;
                }
            }
        }
        if((x1 + x2) %2 != 0 || (y1 + y2) % 2 != 0){
            return -1;
        }
        return x1/2 + y1/2 + (x1%2)*2;
    }
}
