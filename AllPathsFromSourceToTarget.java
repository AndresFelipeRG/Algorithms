import java.util.*;

class Solution {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> paths = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        int n = graph.length;
        
        List<Integer> root = new ArrayList<>();
        root.add(0);
        q.add(root);
        
     
        while(!q.isEmpty()){
            List<Integer> path = q.remove();
            int last = path.get(path.size()-1);
            if(last == n-1) paths.add(path);
            if(!(graph[last] == null || graph[last].length == 0)){
           
                for(int nei: graph[last]){
                    List<Integer> pathCopy = new ArrayList<>(path);
                    pathCopy.add(nei);
                    q.add(pathCopy);
                }
            }
            
        
        }
        
        return paths;
    }
}
