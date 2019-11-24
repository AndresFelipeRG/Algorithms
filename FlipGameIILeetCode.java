import java.util.*;

class Solution {
    
    public boolean canWinUtil(String s, Map<String, Boolean> end){
        
   
        if(end.containsKey(s) ) return end.get(s);
        
        for(int i = 0; i < s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1) && s.charAt(i)== '+'){
                //System.out.println("Before:"+s);
                String s2 = s.substring(0, i) + "--"+ s.substring(i+2);
               // System.out.println("After:"+s2);
                if(!canWinUtil(s2, end)){
                     end.put(s, true);
                     return true;
                }
                
               
            }
        }
        
        end.put(s, false);
        return false;
        
    }
    
    public boolean canWin(String s) {
        
        Map<String, Boolean> end = new HashMap<>();
        return canWinUtil(s, end);
        
    }
}
