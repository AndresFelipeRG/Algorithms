import java.util.*;

class Solution {
    
    List <List<Integer>> g = new ArrayList<>();
    
    int [][] ts;
    int [] delays;
    
    public void dfs(int node, boolean [] visited, int total){
        
       
        //System.out.println(total);
       // if(visited[node] == true){
      //      if(delays[node] > total) delays[node] = total;
     //       return;
     //   }
    //    else{
       
       // visited[node] = true;
        if(delays[node] <= total)  return;
        delays[node] = total;
        for(Integer adj: g.get(node)){
            
                dfs(adj, visited,total+ts[node][adj]);
            
        }
      //  }
        
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        
        ts = new int[N+1][N+1];
        delays = new int[N+1];
        boolean [] visited = new boolean[N+1];
       
        Arrays.fill(delays, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        
        
        
        for(int i = 0; i < N+1;i++){
            g.add(new ArrayList<>());
        }
        
        for(int [] edge: times){
            g.get(edge[0]).add(edge[1]);
            ts[edge[0]][edge[1]] = edge[2];
        }
        
        int ans = 0;
        dfs(K, visited, 0);
        System.out.println(String.valueOf(g));
        System.out.println(Arrays.toString(delays));
        for(int i = 1;  i < delays.length; i++){
            if(delays[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,delays[i]);
        }
        
        return ans;
        
    }
    
}
