import java.util.*;

class Solution {
    
    public void gameOfLife(int[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                
                int ns = 0;
                int r = j + 1 , l = j-1, t = i-1 , d = i+1 ;
                if(r < cols && Math.abs(board[i][r]) == 1) ns++;
                if(r < cols && t >= 0 && Math.abs(board[t][r]) == 1) ns++;
                if(r < cols && d < rows && Math.abs(board[d][r]) == 1) ns++;
                
                if(l >= 0 &&Math.abs(board[i][l]) == 1) ns++;
                if(l >= 0  && t >= 0 && Math.abs(board[t][l]) == 1) ns++;
                if(l >= 0  && d < rows && Math.abs(board[d][l])== 1) ns++;
                
                if(d < rows && Math.abs(board[d][j]) == 1)ns++;
                if(t>= 0 && Math.abs(board[t][j]) == 1) ns++;
                
                if(board[i][j] == 1 && ns < 2){
                    board[i][j] = -1;
                }
                else if(board[i][j] == 1 && ns >=2 && ns <=3) board[i][j] = 1;
                else if(board[i][j] == 1 && ns > 3) board[i][j] = -1;
                else if(board[i][j] == 0 && ns == 3) board[i][j] = 9;
                   
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }}
    }
    
}
