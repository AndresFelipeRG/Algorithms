import java.util.*;


class Solution {
    
    int [] parents;
    int [] ranks;
    public boolean validTree(int n, int[][] edges) {
        
        parents = new int[n];
        ranks = new int[n];
        for(int i = 0; i < n; i++) parents[i] = i;
        for(int i = 0; i < edges.length; i++){
            if(!union(edges[i][0], edges[i][1])){
                return false;
            }
        }
        return edges.length == n-1;
        
    }
    
    public int find(int x){
        
        if(parents[x]!=x){ 
            
            parents[x] = find(parents[x]);
        }
        return parents[x];
        
    }
    
    public boolean union(int x, int y){
        
        int px = find(x);
        int py = find(y);
        if(px == py) return false;
        
        if(ranks[px] < ranks[py]){
            
            parents[px] = py;
            ranks[py] = ranks[py] + 1;
            
        }else {
            parents[py] = px;
            ranks[px] = ranks[px] + 1;
            
        }
        
        return true;
    }
}
