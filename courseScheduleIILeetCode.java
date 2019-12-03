import java.util.*;

class Solution {
    
    List<List<Integer>> graph;
    
    public boolean topSort(int node, Set<Integer> visited, Set<Integer> callback, Stack<Integer> stack){
        
        if(callback.contains(node)) return false;
        if(visited.contains(node)) return true;
        callback.add(node);
        visited.add(node);
        for(int i: graph.get(node)){
            
                if(!topSort(i, visited, callback, stack)) return false;
            
        }
        callback.remove(node);
        stack.push(node);
        
        return true;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        graph = new ArrayList<>();
        
        for(int i = 0; i  < numCourses; i++){
            graph.add(new LinkedList());
        }
        
        for(int [] edge: prerequisites){
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        Set<Integer> callback = new HashSet<>();
        
        Stack<Integer> stack = new Stack();
        System.out.println(String.valueOf(graph));
        for(int i = 0; i < numCourses ; i++){
            if(!visited.contains(i)){
                if(!topSort(i, visited, callback, stack)) return new int[]{};
            }
        }
        int [] ans = new int[stack.size()];
        int i = 0;
        while(!stack.empty()){
            
            ans[i++] = stack.pop() ;
            
        }
        return ans;
    }
    
    
}
