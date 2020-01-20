import java.util.*;

class Solution {
    
    public int orangesRotting(int[][] grid) {
        
        int total = 0;
        int ans = 0;
        int sol = 0;
        int r = grid.length;
        int c = grid[0].length;
        Queue<Integer> q  = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) total++;
                else if(grid[i][j] == 2) q.offer(i*c + j);
            }
        }
        int [][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        //System.out.println(String.valueOf(q));
        while(q.size() > 0){
            int s = q.size();
            
            if(ans == total) return sol;a
            for(int i  = 0; i < s; i++){
                
                Integer e = q.poll();
                int x = e / c;
                int y = e % c;
                for(int [] dir: directions){
                    int px = x + dir[0];
                    int py = y + dir[1];
                    if(px>= 0 && px < r && py >= 0 && py < c && grid[px][py] == 1){
                        q.offer(px*c + py);
                        ans++;
                        grid[px][py] = 2;
                    }
                }
            }
            sol++;
        }
        return ans == total ? sol: -1;
        
    }
}
