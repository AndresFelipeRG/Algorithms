import java.util.Collections;
import java.util.*;
class Solution {
    
    public List<String> traverse(List<List<String>> watchedVideos, int[][] friends, int id, int level){
        
        Queue<ArrayList<Integer>> q = new LinkedList();
        q.offer(new ArrayList<>(Arrays.asList(id, 0)));
        Map<String, Integer> counts = new HashMap<>();
        boolean visited[] = new boolean[friends.length];
        Arrays.fill(visited, false);
        int depth = 0;
        while(q.size() > 0){
            
            ArrayList<Integer> code = q.poll();
            int p = code.get(0);
            int l = code.get(1);
            if(!visited[p] && l == level){
                visited[p] = true;
                for(String video: watchedVideos.get(p)){
                    counts.put(video, counts.getOrDefault(video,0)+1);
                }
            }
            else if (!visited[p]){
                visited[p] = true;
                for(int nei: friends[p]){
                    if(!visited[nei]){
                        q.offer(new ArrayList<>(Arrays.asList(nei, l + 1)));
                    }
                }
            }
        }
        Set<Map.Entry<String, Integer>> set = counts.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2) {
                       
                            return o1.getKey().compareTo(o2.getKey());
                       
            }
        });
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2) {
                        
                        return o1.getValue().compareTo(o2.getValue());
            }
        });
	    ArrayList<String> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: list) ans.add(entry.getKey());
        System.out.println(String.valueOf(list));
        return new ArrayList<>(ans);
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        return traverse(watchedVideos, friends, id, level);
    }
}
