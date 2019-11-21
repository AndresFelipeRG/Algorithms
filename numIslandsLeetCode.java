import java.util.*; 

class Solution {
    
    public ArrayList<ArrayList<Integer>> neighbors(ArrayList<Integer> pair, int r, int c) {
        
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        if (pair.get(0) > 0 ) lst.add(new ArrayList<>(Arrays.asList(pair.get(0)-1, pair.get(1))));
        if (pair.get(1) > 0) lst.add(new ArrayList<>(Arrays.asList(pair.get(0), pair.get(1)-1)));
        if (pair.get(1) <  c - 1) lst.add(new ArrayList<>(Arrays.asList(pair.get(0), pair.get(1) + 1)));
        if (pair.get(0) < r-1) lst.add(new ArrayList<>(Arrays.asList(pair.get(0) + 1, pair.get(1))));
        return lst;
        
    }
    
    public int numIslands(char[][] grid) {
        
        int n2 = grid.length;
        if(n2 == 0) return 0;
        int n1 = grid[0].length;
        if(n1 == 0) return 0;
        Set<ArrayList<Integer>>visited = new HashSet<>();
        int islands = 0;
        for(int i = 0; i < n2; i ++){
            for(int j = 0 ; j < n1; j++){
                  if(grid[i][j] == '1'){
                  ArrayList<Integer> p = new ArrayList<Integer>(Arrays.asList(i,j));
                  if(!visited.contains(p)){
                      islands++;
                      Stack<ArrayList<Integer>> s = new Stack();
                      s.push(p);
                      while(s.size()>0){
                          ArrayList<Integer> p1 = s.pop();
                          visited.add(p1);
                          for(ArrayList<Integer> pair: neighbors(p1, n2, n1)){
                              if(grid[pair.get(0)][pair.get(1)] == '1'){
                              if(!visited.contains(pair)){
                                  s.add(pair);
                              }}
                          }
                      }
                  }}
            }
        }
        return islands;
    }
}
