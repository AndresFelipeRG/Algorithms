import java.util.*;


class Solution {
    
    public boolean isCyclic( Map<Integer, Set<Integer>> graph, int node, Set<Integer> visited, int parent){
        
        visited.add(node);
        Set<Integer> neighbors =  graph.get(node);
        
        for(Integer neighbor: neighbors){
            
        
            if(!visited.contains(neighbor)){
                
                if(isCyclic(graph, neighbor, visited, node)) return true;
                
            }else{
                if(parent != neighbor) return true;
            }
            
        }
        return false;
        
    }
    public boolean validTree(int n, int[][] edges) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        if(edges.length == 0 && n > 1) return false;
        if(edges.length == 0 && n == 1) return true;
        for(int [] edge: edges){
            
            Set<Integer> neighborsA = null;
            Set<Integer> neighborsB = null;
            
            if(graph.containsKey(edge[0])) neighborsA = graph.get(edge[0]);
            else neighborsA = new HashSet<>();
            
            neighborsA.add(edge[1]);
            graph.put(edge[0], neighborsA);
            
            if(graph.containsKey(edge[1])) neighborsB = graph.get(edge[1]);
            else neighborsB = new HashSet<>();
            
            neighborsB.add(edge[0]);
            graph.put(edge[1], neighborsB);
                
        }
        Set<Integer>visited = new HashSet<>();
        int disconnected = 0;
        System.out.println(String.valueOf(graph));
        if(n != graph.keySet().size()) return false;
        for(Integer node: graph.keySet()){
            if(disconnected >= 1 && n > 2) return false;
            if( graph.get(node).size() ==1){
                Iterator<Integer> it = graph.get(node).iterator();
                Integer firstNode = it.next() ;
                
                it = graph.get(firstNode).iterator();
                if(it.next() == node && graph.get(firstNode).size()==1) disconnected++;
            }
            if(!visited.contains(node)){
            if(isCyclic( graph, node, visited, -1)) return false;}
        }
        
        return true;
        
    }
}
