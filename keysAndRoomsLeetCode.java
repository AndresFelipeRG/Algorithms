import java.util.*;

class Solution {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack= new Stack<>();
        int n = rooms.size();
        if(n <= 1) return true;
        stack.add(0);
        
        while(stack.size() > 0){
            
            int top = stack.pop();
            if(!visited.contains(top)){
            visited.add(top);
            for(int room: rooms.get(top)){
                stack.push(room);
            }}
        }
        
        return visited.size() == n;
        
    }
}
