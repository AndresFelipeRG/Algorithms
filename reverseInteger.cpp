class Solution {
public:
    int reverse(int x) {
        
        long y = x;
        unsigned long result = 0;
        unsigned long max = (1<<31) -1 ;
        unsigned long number = (y<0 ?  -y: y);
        int res = 0;
        while(number > 0 ){
            
            result *=10;
            if(number % 10 > 0){
                result += (number % 10);
            }
            number /= 10;
            
        }
        if(result > max){
            return 0;
        }
        res = (x < 0? -( (int) result ): (int) result );
        
        return res;
        
        
        
    }
};
