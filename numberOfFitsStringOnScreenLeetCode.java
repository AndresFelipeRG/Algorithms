import java.util.*;

class Solution {
    
    public int wordsTyping(String[] sentence, int rows, int cols) {
        
        
        if(sentence == null || sentence.length == 0) return 0;
        
        
        String s = String.join(" ", sentence)+" ";
        int l = s.length(); 
        int start = -1;
        
        for(int i = 0; i <  rows ; i++){
                start += cols;
                if(s.charAt((start%l))== ' '){
                 
                   continue;
                }else{
                    if(s.charAt((start+1)%l)== ' '){
                        start++;
                    }else{
                        while(start >= 0 && s.charAt(start%l)!= ' ') start--; 
                    }
                }
               
        }
        return (start+1)/l;
        
    }
    
}
