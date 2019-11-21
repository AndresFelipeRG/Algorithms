import java.util.*; 

class Solution {
    public String build(String s){
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(c != '#') stack.push(c);
            else{
                if(stack.size() > 0 ){
                    stack.pop();
                }
            }
        }
        return String.valueOf(stack);
    }
    public boolean backspaceCompare(String S, String T) {
        Set<String> set = new HashSet<>(Arrays.asList(build(S)));
        return set.contains(build(T));
    }
    
}
