import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
       
        Map<String, List<String>> map = new HashMap<>();
       
        for(String str: strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            
            String key = String.valueOf(s);
            if(map.containsKey(key)){
                List<String> temp = map.get(key);
                temp.add(str);
                map.put(key,temp);
            }else{
                List<String> lst = new ArrayList<>();
                lst.add(str);
                map.put(key, lst);
            }
        }
        
        return new ArrayList(map.values());
    }
}
