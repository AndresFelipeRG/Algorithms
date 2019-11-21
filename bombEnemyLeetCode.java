import java.util.*;

class Solution {
    
    public int maxKilledEnemies(char[][] grid) {
        
        if(grid.length == 0) return 0;
        int ans = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                
              
                int cur = 0;
                
                    int r = i;
                    int c = j;
                    if(grid[r][c] == '0'){
                        
                    
                    
                        
                        int lr = r;
                        int lc = c-1;
                        int rr = r;
                        int rc = c+1;
                        int br = r+1;
                        int bc = c;
                        int tr = r-1;
                        int tc = c;
                    
                        while(lc >= 0 && grid[lr][lc] != 'W' ) {if(grid[lr][lc] == 'E'){cur++;} lc--;};
                        while(rc <  grid[0].length && grid[rr][rc] != 'W' ) {if(grid[rr][rc] == 'E'){cur++;} rc++;};
                        while(tr >= 0 && grid[tr][tc] != 'W' ) {if(grid[tr][tc] == 'E'){cur++;} tr--;};
                        while(br < grid.length && grid[br][bc] != 'W' ) {if(grid[br][bc] == 'E'){cur++;} br++;};
                           
                    }
                
                ans = Math.max(cur, ans);
                cur = 0;
            }
        }
        
        return ans;
        
    }
}
