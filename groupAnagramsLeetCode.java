import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        Map<Map<String,Integer>, List<String>> map = new HashMap<>();
        Set<Map<String, Integer>> set  = new HashSet<>();
        for(String str: strs){
            Map<String, Integer> mapS = new HashMap<>();
            for(int i = 0; i < str.length(); i++){
                if(mapS.containsKey(""+str.charAt(i))){
                    mapS.put(""+str.charAt(i), mapS.get(""+str.charAt(i))+1);
                }
                else{
                    mapS.put(""+str.charAt(i), 1);
                }
            }
            if(set.contains(mapS)){
                List<String> temp = map.get(mapS);
                temp.add(str);
                map.put(mapS,temp);
            }else{
                List<String> lst = new ArrayList<>();
                lst.add(str);
                map.put(mapS, lst);
                set.add(mapS);
            }
        }
        for(Map.Entry entry: map.entrySet()){
           
            result.add((List<String>) entry.getValue());
        }
        return result;
    }
}
