import java.util.*;
class Solution {
    
    public List<String> printVertically(String s) {
        
        String[] words = s.split(" ");
        Map<Integer, String> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int len = 0;
        int pos = 0;
        for(String word: words){
            char [] chars = word.toCharArray();
            len = Math.max(chars.length, len);
            for(int i = 0; i < chars.length; i++){
                String cur = map.getOrDefault(i, "");
                while (cur.length() < pos) cur += " ";
                map.put(i, cur+chars[i]);
            }
            pos++;
        }
        for(int i = 0; i < len; i++) ans.add(map.get(i));
        return ans;
    }
}
