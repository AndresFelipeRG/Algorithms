import java.util.*;


class Solution {
    public boolean halvesAreAlike(String s) {
        
        Set<Character> vowels = new HashSet<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        s = s.toLowerCase();
       
        for(int i = 0; i < n/2; i++){
           
            if(vowels.contains(s.charAt(i))) l++;
            if(vowels.contains(s.charAt(n-i-1))) r++;
        }
     
        return l==r;
    }
}
