import java.util.*;

class Solution {
    
    public int removeStones(int[][] stones) {
        
        Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
        
        for(int i = 0;  i < stones.length; i++){
            for(int j = i+1; j < stones.length; j++){
                
               
                if( stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                 
                if(graph.containsKey(i)){
                    ArrayList<Integer> neighbors = graph.get(i);
                    neighbors.add(j);
                    graph.put(i, neighbors);
                }else{
                    graph.put(i, new ArrayList<>(Arrays.asList(j)));
                }
                    
                 if(graph.containsKey(j)){
                    ArrayList<Integer> neighbors = graph.get(j);
                    neighbors.add(i);
                    graph.put(j, neighbors);
                }else{
                    graph.put(j, new ArrayList<>(Arrays.asList(i)));
                }
                    
                }
                
            }
        }
        int ans = 0;
        boolean [] visited = new boolean[stones.length];
        for(int i = 0; i< stones.length; i++){
            if(!visited[i]){
                ans--;
                Stack<Integer> stack = new Stack();
                stack.push(i);
                visited[i] = true;
                while(!stack.isEmpty()){
                    int p = stack.pop();
                    ans++;
                    if(graph.containsKey(p)){
                    for(int el: graph.get(p)){
                        if(!visited[el]){
                            stack.push(el);
                            visited[el] = true;
                        }
                    }
                    }
                }
            }
            
        }
        return ans;
        
    }
    
}
