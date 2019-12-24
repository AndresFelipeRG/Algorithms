class Solution {
   
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        char [] chars = s.toCharArray();
        Map<String, Integer> counts = new HashMap<>();
        int n = s.length();
        int maxx = 0, i = 0;
        
        while(i < n ){
            
          Map<String, Integer> letters = new HashMap<>();
          int j = i;
          StringBuilder current = new StringBuilder();
          while ( j-i+1 <= maxSize && j < n){
             
              letters.put(String.valueOf(chars[j]), letters.getOrDefault(String.valueOf(chars[j]), 0)+1);
           
              if(letters.keySet().size() > maxLetters) break;
              current.append(String.valueOf(chars[j]));
              if(j-i+1 >= minSize){
                  String s2 = current.toString();
                  counts.put(s2, counts.getOrDefault(s2,0) + 1);
                  maxx = Math.max(counts.get(s2), maxx);
              }
              j++;
          }
         
          i++;
        }
        return maxx;
    }
}
