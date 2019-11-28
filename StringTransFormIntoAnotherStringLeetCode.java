import java.util.*;
//100% MEMORY optimal
//#3% time optimal
class Solution {
    
    public boolean canConvertG( Map<Map<Character, Set<Integer>>, Boolean> res, Map<Character, Set<Integer>> graph, Set< Map<Character, Set<Integer>>>visited, int minChars, Set<Set<Integer>> target){
        Set<Set<Integer>> t = new HashSet<>();
        t.addAll(graph.values());
       
        if(graph.size() < minChars ){
            res.put(graph, false);
            return false;
        }
         if(target.equals(t)){
             if(minChars == 26){
                 if(res.containsKey(graph)){
                     return true;
                 }
                   return false;
             }
            return true;
         };
        if(graph.size() == minChars) return false;
        if(res.containsKey(graph)) return res.get(graph);
        
     //  System.out.println(String.valueOf(graph));
        visited.add((graph));
      // System.out.println("visited:"+String.valueOf(visited));
        for(Character c: graph.keySet()){
            for(char a = 'a' ; a <= 'z'; a++){
                
                Character cA = Character.valueOf(a);
                if(!c.equals(cA)){
                    Map<Character, Set<Integer>> temp = new HashMap<>();
                    temp.putAll(graph);
                    if(temp.containsKey(cA)){
                        
                        Set<Integer> indx = new HashSet<>();
                        indx.addAll(temp.get(cA));
                        temp.remove(cA);
                        Set<Integer> indxb = new HashSet<>();
                        indxb.addAll(temp.get(c));
                        indx.addAll(indxb);
                        temp.remove(c);
                        temp.put(cA, indx);
                    }
                    else {
                        
                        HashSet<Integer> indx = new HashSet<>();
                        indx.addAll(temp.get(c));
                        temp.remove(c);
                        temp.put(cA, indx);
                    }
                    
                   
                   if(!visited.contains((temp))){
                    if(canConvertG(res, temp, visited, minChars, target)){
                        res.put(temp, true);
                        return true;
                    }}
                    
                }
            }
        
        }
        res.put(graph, false);
        return false;
    }
    public boolean canConvert(String str1, String str2) {
        
         Map<Map<Character, Set<Integer>>, Boolean> res = new HashMap<>();
         
         Map<Character, Set<Integer>> first = new HashMap<>();
        
         Set< Map<Character, Set<Integer>>> visited = new HashSet<>();
        
         char [] chars = str2.toCharArray();
         for(int i = 0; i < chars.length; i++){
             
             Character cObj = Character.valueOf(chars[i]);
             if(first.containsKey(cObj)){
                 Set<Integer> indx =first.get(cObj) ;
                 indx.add(i);
                 first.put(cObj, indx);
             }else{
                 
                 first.put(cObj, new HashSet(Arrays.asList(i)));
             }
             
         }
        
         res.put(first, true);
         chars = str1.toCharArray();
         Map<Character, Set<Integer>> graph  = new HashMap();
         for(int i = 0; i < chars.length; i++){
             
             Character cObj = Character.valueOf(chars[i]);
             if(graph.containsKey(cObj)){
                 Set<Integer> indx = graph.get(cObj) ;
                 indx.add(i);
                 graph.put(cObj, indx);
             }else{
                 
                 graph.put(cObj, new HashSet(Arrays.asList(i)));
             }
             
         }
         System.out.println(String.valueOf(res));
         System.out.println(String.valueOf(graph));
         Set<Set<Integer>> target = new HashSet<>();
         target.addAll(first.values());
         return canConvertG(res, graph, visited, first.size(), target);
        
    }
}
