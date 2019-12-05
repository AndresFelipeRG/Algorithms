class Solution {
    
    int [] parents;
    int [] ranks;
    
    public int[] findRedundantConnection(int[][] edges) {
        
        parents = new int[edges.length+1];
        ranks = new int[edges.length+1];
        for(int i = 0; i < parents.length; i++) parents[i] = i;
        for(int [] edge: edges){
            if(!union(edge[0], edge[1])) return edge;
        }
        return new int[0];
        
    }
    
    public int find(int x){
        if(parents[x] != x){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    
    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py) return false;
        else if ( ranks[px] < ranks[py]){
            parents[px] = py;
            ranks[px]++;
        }
        else if(ranks[px] >= ranks[py]){
            parents[py] = px;
            ranks[py]++;
        }
        return true;
        
    }
}
