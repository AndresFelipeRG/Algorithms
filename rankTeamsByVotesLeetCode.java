
import java.util.*;

class Solution {
    
    public String rankTeams(String[] votes) {
        
        if (votes == null) return "";
        StringBuilder ans = new StringBuilder();
        int voters = votes.length;
        if (voters == 0) return "";
        int candidates = votes[0].length();
        if (candidates == 1 || voters == 1) return votes[0];
        Map<Character, List<Integer>> counts = new HashMap<>();
       
        for(String vote: votes){
            for(int i = 0; i < candidates; i++){
                char c = vote.charAt(i);
                List<Integer> def = Arrays.asList(new Integer[candidates+1]);
                Collections.fill(def, new Integer(0));
                List<Integer> cs = counts.getOrDefault(c, def);
                cs.set(i, cs.get(i)+1);
                cs.set(candidates, (int) c);
                counts.put(c, cs);
               
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(Character c: counts.keySet()) result.add(counts.get(c));
        System.out.println(candidates);
        System.out.println(String.valueOf(result));
        Collections.sort(result, new Comparator<List<Integer>> () {
                         @Override
                         public int compare(List<Integer> a, List<Integer> b){
                                                        
                                                             for(int i = 0; i < candidates; i++){
                                                               
                                                                 if(a.get(i).intValue() != b.get(i).intValue()){ return -a.get(i)+b.get(i);}
                                                             }
                                                                  
                                                             return a.get(candidates) - b.get(candidates);}
        }
                                                             );
       
        //System.out.println(String.valueOf(counts));
       // System.out.println(String.valueOf(result));
        for(int i = 0; i < result.size(); i++){
            ans.append((char)(result.get(i).get(candidates).intValue()));
        }
        return ans.toString();
        
    }
}
