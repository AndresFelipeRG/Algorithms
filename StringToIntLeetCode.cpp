class Solution {
public:
    int myAtoi(string str) {
        
        char first = ' ';
        int negative = 1;
        int left = 0;
        int right = 0;
        if(str.length() == 0){
            return 0;
        }
        for(int i = 0; i < str.length(); i++){
            
            if(str[i] != ' '){
                first = str[i];
                if(!isdigit(first) && (first != '-'| first != '+') && ( i + 1 < str.length() && !isdigit(str[i+1]))){
                    return 0;
                }
                else{
                    if(str[i] == '-'){
                        negative = -1;
                        left = i + 1;
                        break;
                    }
                    if(str[i] == '+'){
                        
                        left = i + 1;
                        break;
                    }
                    left = i;
                    break;
                }
            }
        }
        for(int i = left; i < str.length(); i++){
            
            right = i;
            if(!isdigit(str[i])){
                right = right - 1;
                break;
            }
            
        }
        int len = (right - left) + 1;
        long int max = (1<<31) -  1;
        long int number = 0;
        for(int i = left; i <= right ; i++){
            number = number*10 + (str[i]-'0');
             if(negative == 1){
               if(number > max){
                return max;
               }
              }
             if(negative == -1){
               if(number >= max + 1){
                return  -max - 1;
                }
              }
        }
       
        int number_ok = 0;
        for(int i = left; i <= right ; i++){
            number_ok = number_ok*10 + (str[i]-'0');
        }
        
        
        return number_ok*negative;
        
        
    }
};
