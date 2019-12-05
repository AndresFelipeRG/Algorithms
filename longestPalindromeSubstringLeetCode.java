class Solution {
    
    public String longestPalindrome(String s) {
        if(s.length() == 1 || s.length() == 0) return s;
       
        int start = 0;
        int longest = 1;
        for(int i = 1; i < s.length() ; i++){
            int l = i - 1;
            int r  = i + 1;
            while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l + 1 > longest){
                    start = l;
                    longest = r-l+1;
                }
                l--;
                r++;
            }
            l = i-1;
            r = i;
            while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l + 1 > longest){
                    start = l;
                    longest = r-l+1;
                }
                l--;
                r++;
            }
        }
        return s.substring(start, start+longest);
    }
}
