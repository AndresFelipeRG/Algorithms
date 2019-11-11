import java.util.*;
import java.util.regex.*;
class Solution {
    
    public boolean isAFile(String file){
         return file.contains(".");
    }
    public int lengthLongestPath(String input) {
         if(input.length() == 0){return 0;}
         int count = 0;
         
         String [] array = input.split("\n");
         
         Map<Integer, Integer> map = new HashMap<>();
         map.put(0,0);
         for(String s: array){
            String noTabs = s.replaceAll("\\t", "");
            int level = s.length() - noTabs.length();
            if(isAFile(s)){
                 count = Math.max(count, map.get(level) + noTabs.length());
            }
            else{
               
                 map.put(level + 1, map.get(level)+ noTabs.length() + 1);
            }
           
         }
         return count;
    }
}
