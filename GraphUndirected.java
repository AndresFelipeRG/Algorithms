import java.io.*;
import java.util.*;

class GraphUndirected {
    private int V;
    private LinkedList<Integer> adj[];

    GraphUndirected(int v){
        this.V = v;
        adj = new LinkedList<>[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    Boolean isCyclicUtile(int v, Boolean visited[], int parent){
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj[v].iterator();
        while(it.hasNext()){

            i = it.next();
            if(!visited[i]){
                 if(isCyclicUtil(i, visited, v)){
                     return true;
                 }
            }
            else {
                if(parent != v){
                    return true;
                }
            }
        }
    }
    Boolean isCyclic(){
        Boolean visited[] = new Boolean[this.V];
        for(int i=0 ; i < V; i++){
            visited[i] = false;
        }
        for(int u = 0; u < V; u++){
            if(!visited[i]){
                if(isCyclicUtil(u, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }
}
