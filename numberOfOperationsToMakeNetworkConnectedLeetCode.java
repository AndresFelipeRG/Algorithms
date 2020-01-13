import java.util.*;

class Solution {
    public int find(int [] parent, int i){
        while(i != parent[i]) i = parent[i];
        return i;
    }
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n -1) return -1;
        int [] parent = new int [n];
        for(int i = 0; i < n; i++) parent[i] = i;
        int groups = 0;
        int additionalEdges = 0;
        for(int [] edge: connections){
            int sa = find(parent, edge[0]);
            int sb = find(parent, edge[1]);
            if(sa == sb) additionalEdges++;
            else parent[sa] = sb;
        }
        
        for(int i = 0; i < n; i++) if(parent[i] == i) groups++;
        return additionalEdges >= groups -1 ? groups -1 : -1;
        
    }
}
