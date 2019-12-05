import java.util.*;

class Solution {
Map<String, PriorityQueue<String>> mapT;
List<String> itinerary = new ArrayList<>();

public List<String> findItinerary(List<List<String>> tickets) {
    mapT = new HashMap<>();
    for(List<String> ticket: tickets){
        if(!mapT.containsKey(ticket.get(0))){
            mapT.put(ticket.get(0), new PriorityQueue<String>());
        }
        mapT.get(ticket.get(0)).add(ticket.get(1));
    }
    dfsFindRoute("JFK");
    return itinerary;
}
private void dfsFindRoute(String departure) {
   PriorityQueue<String> queue = mapT.get(departure);
   while (queue != null && queue.size() > 0){
       dfsFindRoute(queue.poll());
   }
   itinerary.add(0, departure);
   
}
}
