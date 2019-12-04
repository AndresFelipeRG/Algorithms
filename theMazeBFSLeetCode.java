import java.util.*;

class Solution {
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        int r = maze.length;
        int c = maze[0].length;
        int [][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
        int tx = destination[0];
        int ty = destination[1];
        boolean [][] visited = new boolean[maze.length][maze[0].length];
        for(int i = 0; i < maze.length; i++)Arrays.fill(visited[0], false);
        
        int px = start[0];
        int py = start[1];
        queue.add(new ArrayList<>(Arrays.asList(px, py)));
        
        visited[px][py] = true;
        while(!queue.isEmpty()){
            
            ArrayList<Integer> pos = queue.remove();
            px = pos.get(0);
            py = pos.get(1);
             if (px == tx && py == ty) return true;
           
            
            for(int dir[]: directions){
                
                int x = px + dir[0];
                int y = py + dir[1];
               
                
                while(x >= 0 &&  y >= 0 && x < r
                     &&  y < c && maze[x][y] == 0){
                     x = dir[0] +  x ;
                     y = dir[1] + y;
               }
              if(!visited[x-dir[0]][y-dir[1]]) {
                  queue.offer(new ArrayList<>(Arrays.asList(x-dir[0], y-dir[1])));
                  visited[x-dir[0]][y-dir[1]]= true;
                                               }
             
            
            }
        }
        
        return false;
    }
}
