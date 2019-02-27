class Solution {
public:
    string convert(string s, int numRows) {
        
        string result = "";
        if(s.length() == 1|| numRows == 1){
            return s;
        }
        for(int i = 0; i < numRows; i++){
            
            int index = i;
            while(index < s.length()){
                
                result.append(1, s[index]);
                if(numRows >1 && i%(numRows-1) != 0 && index+ (numRows-1)*2 -2*(i) < s.length()){
                    result.append(1, s[index+ (numRows-1)*2 -2*(i)]);
                }
                index += (numRows -1)*2;
                
                
            }
            
            
        }
        return result;
    }
};
