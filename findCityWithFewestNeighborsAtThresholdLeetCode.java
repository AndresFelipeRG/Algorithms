import java.util.*;

class Solution {
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        Map<Integer, List<List<Integer>>> g = new HashMap<>();
        
        int ans = 0;
        for(int [] edge: edges){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            if(g.containsKey(from)){
                g.get(from).add(new ArrayList<>(Arrays.asList(to, weight)));
            }
            else {
                List<List<Integer>> lst = new ArrayList<>();
                lst.add(new ArrayList<>(Arrays.asList(to,weight)));
                g.put(from, lst);
            }
             if(g.containsKey(to)){
                g.get(to).add(new ArrayList<>(Arrays.asList(from, weight)));
            }
            else {
                List<List<Integer>> lst = new ArrayList<>();
                lst.add(new ArrayList<>(Arrays.asList(from,weight)));
                g.put(to, lst);
            }
        }
        //System.out.println(String.valueOf(g));
        int counts [] = new int[n];
        
        for(int i = 0; i < n; i++){
            
            if(g.containsKey(i)){
            PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>> ((u,v) -> u.get(1) - v.get(1));
            int [] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[i] = 0;
            pq.add(new ArrayList<>(Arrays.asList(i,0)));
           
            
            while( pq.size() > 0 ){
                List<Integer> node = pq.poll();
                
                int cur = distances[node.get(0)];
                
                for(List<Integer> city: g.get(node.get(0))){
                    
                    int d = distances[city.get(0)];
                    int d2 = cur + city.get(1);
                    if(d2 < d){ distances[city.get(0)] = d2;
                    
                    pq.add(new ArrayList<>(Arrays.asList(city.get(0), distances[city.get(0)])));
                              }
                    
                }
            }
        //  System.out.println(Arrays.toString(distances));
            int count = 0;
            for(int j = 0; j < distances.length; j++){
                if(j != i) if(distances[j] <= distanceThreshold) count++;
            }
            counts[i] = count;
            }
        }
       // System.out.println(Arrays.toString(counts));
        ans  = counts[0];
        for(int i = 0; i< n; i++){
            if(counts[i] == counts[ans]) ans = Math.max(ans, i);
            else if(counts[i] < counts[ans]) ans = i;
        }
        
        return ans;
    }
}
