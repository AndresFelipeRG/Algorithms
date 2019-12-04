import java.util.*;

class Solution {
    
    public boolean dfs(int [][] maze, int [] start, int [] destination, boolean [][] visited){
        
        if(visited[start[0]][start[1]]) return false;
        if( destination[0] == start[0] && start[1] == destination[1]) return true;
        
        visited[start[0]][start[1]] = true;
        
        int u = start[0]- 1;
        int d = start[0]+1;
        int r = start[1] + 1;
        int l = start[1] - 1;
        
        while(u >= 0 && maze[u][start[1]] == 0) u--;
        if(dfs(maze, new int []{ ++u, start[1]}, destination, visited)) return true;
        
        while(  d < maze.length && maze[d][start[1]] == 0) d++;
        if(dfs(maze, new int[]{ --d, start[1]}, destination, visited)) return true;
        
        while( r < maze[0].length && maze[start[0]][r] == 0) r++;
        if(dfs(maze, new int[]{ start[0],--r}, destination, visited)) return true;
        
        while(l >= 0 && maze[start[0]][l] == 0) l--;
        if(dfs(maze, new int[]{start[0],++l}, destination, visited)) return true;
        
        return false;
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        boolean [][] visited = new boolean[maze.length][maze[0].length];
       
        return (dfs(maze, start, destination, visited)) ;
    }
}
