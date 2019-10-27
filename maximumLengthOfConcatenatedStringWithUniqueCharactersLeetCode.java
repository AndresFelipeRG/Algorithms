import java.util.*;
class Solution {
    public int maxLength(List<String> arr) {
        
        List<Set<Character>> lst = new ArrayList<>();
        lst.add(new HashSet<>());
        int sol = 0;
        for(String str: arr){
            List<Character> lcs = new ArrayList<>();
            for(char c: str.toCharArray()){
                lcs.add((Character) c);
            }
            Set<Character> s = new HashSet<>(lcs);
            if(s.size() != lcs.size()){continue;}
            Set<Character> copy = new HashSet<>();
            Iterator<Set<Character>> it = lst.iterator();
            List<Set<Character>> tempL = new ArrayList<>();
            while(it.hasNext()){
               Set<Character> set = (Set<Character>) it.next();
               tempL.add(set);
               copy = new HashSet<>(lcs);
               copy.retainAll(set);
               if(copy.size()== 0){
                  
                   Set<Character> temp = new HashSet<>();
                   temp.addAll(set);
                   temp.addAll(s);
                   tempL.add(temp);
               }
               
            }
            lst = tempL;
        }
        for(Set<Character> set: lst){
            sol = set.size() > sol? set.size(): sol;
        }
        return sol;
    }
}
