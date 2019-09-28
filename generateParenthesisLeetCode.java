class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> response = new ArrayList<>();
        if(n == 0){
            response.add("");
            return response;
        }
        if(n == 1){
            response.add("()");
            return response;
        }
        
            
            
            for(int j = n-1; j >=0 ; j--){
                
                for(String left : generateParenthesis(j) ){
                    for(String right : generateParenthesis(n-1-j)){
                        
                        String temp = "("+left+")" + right;
                        response.add(temp);
                    }
                }
                
                
            }
        return response;
            
        
    }
}
