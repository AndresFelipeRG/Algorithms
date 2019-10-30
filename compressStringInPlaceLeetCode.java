import java.util.*;
class Solution {
    
    public int modify(char [] chars, int l,  String qte){
        char [] aQte = qte.toCharArray();
        //System.out.println(aQte);
        
        int i = l;
        int j = 0 ;
        while(j < aQte.length){
            chars[i] = aQte[j];
            j+=1;
            i+=1;
        }
        return i;
    }
    public int countC(char [] chars, int l, char target){
      
        int count = 0;
        while( l < chars.length){
            if(chars[l] != target){
                break;
            }
            count += 1;
            l+=1;
        }
        return count;
    }
    public int compress(char[] chars) {
        
        if(chars.length == 0){
            return 0;
        }
        if(chars.length == 1){
            return 1;
        }
        
        int i = 0;
       
        int  lastIndex = 0;
        while(i < chars.length){
            
            
                
                int n = countC(chars, i, chars[i]);
                
                String qte = n > 1 ? String.valueOf(chars[i]) + Integer.toString(n): String.valueOf(chars[i]) ;
                
                lastIndex = modify(chars, lastIndex, qte);
                
                i = i + n;
            
           
        }
        return lastIndex;
        
    }
}
