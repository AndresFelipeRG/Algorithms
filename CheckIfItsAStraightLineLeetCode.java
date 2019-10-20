import java.util.*;
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
     
        int min_x = coordinates[0][0];
        int l = 0;
        int max_x = coordinates[0][0];
        int r = 0;
        
        for(int i = 0; i < coordinates.length; i++){
          
            if(coordinates[i][0] < min_x){
                min_x = coordinates[i][0];
                l = i;
            }
            if(coordinates[i][0] > max_x){
                max_x = coordinates[i][0];
                r = i;
            }

            
        }
        int dx = coordinates[r][0]  - coordinates[l][0] ;
        int dy = coordinates[r][1]  - coordinates[l][1] ;
        int b = 0;
        int c = 0;
        if(dx == 0){
            for(int i = 0; i < coordinates.length; i++){
                if(coordinates[i][0] != min_x){
                    return false;
                }
            }
            return true;
        }
        if(dy == 0){
            c = coordinates[l][1];
        }
        else{
            b = dy/dx;
            c = coordinates[0][1]- coordinates[0][0]*b;
        }
        for(int i = 0; i < coordinates.length; i++){
            
           int y = coordinates[i][1];
           if(b*coordinates[i][0] + c != y){
               return false;
           }
            
        }
        return true;
    }
}
