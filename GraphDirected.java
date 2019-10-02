import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GraphDirected {

        private final int V;
        private final List<List<Integer>> adj;

        public GraphDirected(int v){
            this.V = v;
            this.adj = new ArrayList<>(v);
            for(int i = 0 ; i < v; i++){
                adj.add(new LinkedList<>());
            }
        }

        private void addEdge(int v, int w){
            this.adj.get(v).add(w);
        }

        private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack){
            if(recStack[i]){
                return true;
            }
            if(visited[i]){
                return false;
            }
            visited[i] = true;
            recStack[i] = true;
            List<Integer> children = this.adj.get(i);
            for(Integer c: children){
                if(isCyclicUtil(c, visited, recStack)){
                    return true;
                }
            }
            recStack[i] = false;
            return false;
        }

        private boolean isCyclic(){
            boolean []visited = new boolean[this.V];
            boolean [] recStack = new boolean[this.V];

            for(int i = 0; i < V; i++){
                if(isCyclicUtil(i, visited, recStack)){
                    return true;
                }
            }
            return false;
        }
}
