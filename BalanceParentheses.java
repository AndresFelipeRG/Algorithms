import java.util.*;
class Solution {
    
   
    public boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }
        Stack<String> stack = new Stack<>();
        
        String [] chars = s.split("");
        for(int i = 0; i < chars.length; i++){
            if(chars[i].equals("(")|| chars[i].equals("[") || chars[i].equals("{")){
                stack.push(chars[i]);
            }
            else{
                if(stack.size() == 0){
                    return false;
                }
                String _char = stack.peek();
                stack.pop();
                if(!(chars[i].equals(")")|| chars[i].equals("]") || chars[i].equals("}"))){
                   return false;
                    
                }
                if (chars[i].equals(")")){
                        if(!_char.equals("(")){
                            return false;
                        }
                    }
                    if(chars[i].equals("}")){
                        if(!_char.equals("{")){
                            return false;
                        }
                    }
                    if(chars[i].equals("]")){
                        if(!_char.equals("[")){
                            return false;
                        }
                    }
            }
        }
        if(stack.size()>0){
            return false;
        }
        return true;
      
    }
}
