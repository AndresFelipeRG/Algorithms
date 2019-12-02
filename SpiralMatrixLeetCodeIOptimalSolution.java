import java.util.*;


class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        
        List<Integer> ans = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        int [][] offset = {{0,1},{1,0},{0,-1},{-1,0}};
        int i = 0;
        int j = 0;
        int k = 0;
        while(matrix.length > 0 && visited.size() != matrix.length*matrix[0].length){
           if(!visited.contains(matrix[i][j])){
                 visited.add(matrix[i][j]);
                 ans.add(matrix[i][j]);}
           if (i + offset[k][0] == matrix.length || j + offset[k][1] == matrix[0].length || i + offset[k][0] < 0 || j + offset[k][1] < 0 ||
              visited.contains(matrix[i + offset[k][0]][ j + offset[k][1]]) ){
               k = (k+1)%offset.length;
               
           }else{
               i = i + offset[k][0];
               j = j + offset[k][1];
           }
           
        }
        
        return ans;
    }
}
