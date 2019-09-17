class Solution {
    public String longestCommonPrefix(String[] strs) {
       
       
        int index = 0;
        if(strs.length == 0){
            return "";
        }
        int minIndex = strs[0].length();
        if(strs[0].length() == 0){
            return "";
        }
        char first = strs[0].charAt(0);
        int minLength = strs[0].length();
        for(int i = 0 ; i < strs.length; i++){
            if(strs[i].length() < minLength){
                minLength = strs[i].length() ;
            }
            if(strs[i].length() == 0){
                return "";
            }
            if(strs[i].charAt(0) != first){
                return "";
            } 
        }
        minIndex = minLength;
        for(int i = 1; i < strs.length; i++) {
            for(int j = 0;  j < minLength;j++){
                if(strs[i].charAt(j) != strs[0].charAt(j)){
                    index = j;
                    if( index < minIndex){
                        minIndex = j;
                    }
                    break;
                }
                
            }
            
        }
        
        return strs[0].substring(0, minIndex);
        
        
    }
}
