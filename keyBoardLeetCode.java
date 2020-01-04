import java.util.*;
class Solution {
    
    public String[] findWords(String[] words) {
        if (words == null) return null;
       // Set<Character> r1 = new HashSet<>(), r2 = new HashSet<>(), r3 = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        for(char c: Arrays.asList('q','w','e','r','t','y','u', 'i','o','p')) map.put(c, "row1");
        for(char c: Arrays.asList('a','s','d','f','g','h','j', 'k','l')) map.put(c, "row2");
        for(char c: Arrays.asList('z','x','c','v','b','n','m')) map.put(c, "row3");
      
        ArrayList<String> result = new ArrayList<>();
        System.out.println(String.valueOf(map));
        top: for(String word: words){
            if(word.length() == 0) continue;
            char chars[] = word.toLowerCase().toCharArray();
            String row = map.get(chars[0]);
            for(char c: chars) if(!map.get(c).equals(row)) continue top;
            result.add(word);
        }
        
       // String ans[] = new String[result.size()];
        return result.toArray(new String[result.size()]);
    }
}
