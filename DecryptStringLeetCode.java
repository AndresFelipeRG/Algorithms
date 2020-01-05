class Solution {
    public String freqAlphabets(String s) {
        if(s == null)return "";
        int n = s.length();
        if(n == 0) return "";
        StringBuilder builder = new StringBuilder();
        
        for(int i = n-1; i>=0; i--){
            if(s.charAt(i) == '#'){
                builder.insert(0, ""+(char)((Integer.parseInt(""+s.charAt(i-2)+s.charAt(i-1))-10) + (int)'j') );
                i = i - 2;
            }
            else{
                builder.insert(0,""+ (char)(Integer.parseInt(""+s.charAt(i))-1 + (int)'a'));
            }
        }
        return builder.toString();
    }
}
