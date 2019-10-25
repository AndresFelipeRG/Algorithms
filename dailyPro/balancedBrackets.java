import java.util.*;
class Program {
  public static boolean balancedBrackets(String str) {
    // Write your code here.
		Map<String, String> map = new HashMap<>();
		map.put("}", "{");
		map.put("]","[");
		map.put(")","(");
		Stack<String> stack = new Stack<>();
		char[] chars = str.toCharArray();
		for(char c: chars){
			 if(!map.containsKey(""+c)){
				  stack.push(""+c);
			 }
			 else{
				  if(stack.size() == 0){
						return false;
					}
				  if(!map.get(""+c).equals(stack.pop())){
						 return false;
					}
			 }
		}
		if(stack.size() > 0){
			return false;
		}
		return true;
  }
}
