import java.util.*;

class Solution {
Map<String, PriorityQueue> mapTickets = new HashMap<>();
List itinerary = new ArrayList<>();

public List<String> findItinerary(List<List<String>> tickets) {
    
    for (List<String> ticket : tickets) {
        String departure = ticket.get(0);
        String arrival = ticket.get(1);
        if (!mapTickets.containsKey(departure)) {
            mapTickets.put(departure, new PriorityQueue<String>());
        }
        mapTickets.get(departure).add(arrival);
    }
    dfsFindRoute("JFK");
    return itinerary;
}
private void dfsFindRoute(String departure) {
    PriorityQueue<String> arrivals = mapTickets.get(departure);
    while (arrivals != null && !arrivals.isEmpty()) {
        dfsFindRoute(arrivals.poll());
    }
    itinerary.add(0,departure);
}
}
