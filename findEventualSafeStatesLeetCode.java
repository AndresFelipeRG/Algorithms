import java.util.*;


class Solution {
    
    public boolean safe(int [][] graph, int i, Set<Integer> visited, Set<Integer> callback){
        

        if(callback.contains(i)) return false;
        if(visited.contains(i)) return true;
        callback.add(i);
        visited.add(i);
        for(int neighbor: graph[i]){
            if(!safe(graph, neighbor, visited, callback)){
                return false;
            }
        } 
        callback.remove(i);
        return true;
        
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < graph.length; i++){
          
            Set<Integer> callback = new HashSet<>();
            Set<Integer> visited = new HashSet<>();
            if(safe(graph, i,  visited,callback)) ans.add(i); 
        }
        return ans;
    }
    
}
