import java.util.*; 

class Solution {
    
    public boolean backspaceCompare(String S, String T) {
        
        Set<String> s = new HashSet<>();
        StringBuilder str = new StringBuilder("");
        for(int i = S.length()-1 ; i >= 0; i--){
            
            int off = 0;
            int j = i;
            while(j>= 0 && S.charAt(j) == '#') {j--; off++;}
            
            while(j>= 0 && off > 0){ if(S.charAt(j) != '#'){off--;} else{ off++;}j--;};
            i = j;
            
            if(i>= 0 && S.charAt(i)!= '#') str.append(S.charAt(i));
            else{i++;}
           
        }
        System.out.println(str.toString());
        s.add(str.reverse().toString());
        str = new StringBuilder("");
        for(int i = T.length()-1; i >= 0; i--){
            
            int off = 0;
            int j = i;
            while(j>= 0 && T.charAt(j) == '#') {j--; off++;}
           
            while(j>= 0 && off > 0){ if(T.charAt(j) != '#'){off--;} else{ off++;}j--;};
            i = j;
            
            if(i>=0 && T.charAt(i)!= '#') str.append(T.charAt(i));
            else{i++;}
            
        }
        System.out.println(str.toString());
        return s.contains(str.reverse().toString());
    }
    
}
