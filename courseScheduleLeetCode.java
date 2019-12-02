import java.util.*;

class Solution {
    Map<Integer, ArrayList<Integer>> graph;
    public boolean isCyclic(Integer course, Set<Integer> visited, Set<Integer> callback){
        
        if(callback.contains(course)) return true;
        if(visited.contains(course)) return false;
        visited.add(course);
        callback.add(course);
        if(graph.containsKey(course)){
        for(Integer next: graph.get(course) ){
            
            if(isCyclic(next, visited, callback)){
                return true;
            }
         
        }}
        callback.remove(course);
        return false;
        
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        graph = new HashMap<>();
        for(int [] courses: prerequisites){
            
            ArrayList<Integer> neighbors = new ArrayList<>();
            if(graph.containsKey(courses[1])) neighbors = graph.get(courses[1]);
            neighbors.add(courses[0]);
            graph.put(courses[1], neighbors);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> callback = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(isCyclic(i, visited, callback)) return false;
        }
        return true;
        
    }
}
