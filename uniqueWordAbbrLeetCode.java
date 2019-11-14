import java.util.*;

class ValidWordAbbr {
    
    Map<String, Boolean> dict;
    Set<String> words;
    
    public ValidWordAbbr(String[] dictionary) {
        
        this.dict = new HashMap<>();
        this.words = new HashSet<>(Arrays.asList(dictionary));
        
        for(String s: words){
            
            String abbr = toAbbr(s);
            this.dict.put(abbr, !this.dict.containsKey(abbr));
            
        }
         
    }
    
    public boolean isUnique(String word) {
        
        String abbr =  toAbbr(word);
        Boolean hasAbbr = this.dict.get(abbr);
        return hasAbbr == null || (hasAbbr && words.contains(word));
        
    }
    public String toAbbr(String word){
        int n = word.length();
        if(word.length()> 2){
            return word.charAt(0) + String.valueOf(n-2)+ word.charAt(n-1);
        }
        return word;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
