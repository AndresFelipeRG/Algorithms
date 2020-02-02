import java.util.*;

class Solution {
    
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> filtered = new PriorityQueue<>((u,v)-> u[1]==v[1]? -u[0]+v[0]: -u[1]+v[1]);
        
        for(int [] restaurant: restaurants){
            
            if(restaurant[3] <= maxPrice && restaurant[4] <=maxDistance &&  (restaurant[2] == veganFriendly || veganFriendly==0) ) filtered.offer(((restaurant)));
        }
        
        while(filtered.size() > 0){
            ans.add(filtered.poll()[0]);
        }
        return ans;
    }
}
