import java.util.*;
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> g = buildGraph(n ,edges);
        int result = 0, reachableCities = n;
        for(int city = 0; city < n; city++){
            int[] costs = dijsktra(city, g, n);

            int count = 0;
            for(int cost : costs){
                if(cost <= distanceThreshold){
                    count++;
                }
            }
            if(count <= reachableCities){
                result = city;
                reachableCities = count;
            }
        }
        return result;
    }
    int[] dijsktra(int sourceCity, Map<Integer, List<int[]>> g, int n){
        int[] costs = new int[n];
        Arrays.fill(costs, 10001);

        PriorityQueue<Integer> queue = new PriorityQueue<>((cityA, cityB) -> costs[cityA] - costs[cityB]);
        costs[sourceCity] = 0;
        queue.add(sourceCity);
        while (!queue.isEmpty()){
            int currentCity = queue.poll();
            List<int[]> neighbours = g.get(currentCity);
            for(int[] c: neighbours){
                int toCity = c[0], distance = c[1];
                if(costs[toCity] > costs[currentCity] + distance){
                    costs[toCity] = costs[currentCity] + distance;
                    queue.add(toCity);   
                }
            }
        }
        return costs;
    }

    Map<Integer, List<int[]>> buildGraph(int totalCities, int[][] edges){
        Map<Integer, List<int[]>> g = new HashMap<>();

        for(int city = 0; city < totalCities; city++){
            g.put(city, new ArrayList<>());
        }

        for(int[] e : edges){
            int cityA = e[0], cityB = e[1], distance = e[2];
            g.get(cityA).add(new int[]{cityB, distance});
            g.get(cityB).add(new int[]{cityA, distance});
        }
        return g;
    }
}
