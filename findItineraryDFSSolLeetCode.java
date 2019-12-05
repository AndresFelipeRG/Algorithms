class Solution {
    int length;
    List<String> res = new ArrayList<>();
    class Edge {
        String from;
        String to;
        boolean visited;
        public Edge(String f, String t) {
            from = f;
            to = t;
            visited = false;
        }
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) return res;
        length = tickets.size() + 1;
        // construct graph
        Map<String, List<Edge>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (graph.containsKey(from)) graph.get(from).add(new Edge(from, to));
            else {
                List<Edge> edge = new ArrayList<>();
                graph.put(from, edge);
                edge.add(new Edge(from, to));
            }
        }
        // sort edges in itinerary order
        for (List<Edge> edge : graph.values()) {
            edge.sort((e1, e2)->e1.to.compareTo(e2.to));
        }
        res.add("JFK");
        dfs(graph, res);
        return res;
    }
    
    private void dfs(Map<String, List<Edge>> graph, List<String> path) {
        // leaf node, find a valid solution
        if (path.size() == length) {
            res = new ArrayList<>(path);
            return ;
        }
        String from = path.get(path.size() - 1);
        List<Edge> edges = graph.get(from);
        // leaf node, but invalid path
        if (edges == null || edges.size() == 0) return ;
        
        // iterate edges
        for (Edge edge : edges) {
            if (!edge.visited) {
                edge.visited = true;
                path.add(edge.to);
                dfs(graph, path);
                // if find the first valid path (because of sorted edges), we can just stop DFS
                if (res.size() == length) return ;
                edge.visited = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
