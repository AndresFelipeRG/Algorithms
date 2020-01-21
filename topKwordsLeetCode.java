import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> f = new HashMap<>();
        for(String word: words){
            f.put(word,  f.getOrDefault(word,0) + 1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a, b)->a.getValue()== b.getValue() ? b.getKey().compareTo(a.getKey()): a.getValue() - b.getValue());
            
        for(Map.Entry<String, Integer> e : f.entrySet()){
            pq.offer(e);
            if(pq.size() > k){
                pq.poll();
            }
            }
        
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(0, pq.poll().getKey());
        }
              
              
    
                      return ans;                                                    
                                                                 
                               }   
                                                                          
}
