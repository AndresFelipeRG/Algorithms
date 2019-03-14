class Solution {
public:
    bool isPalindrome(int x) {
        
        if(x < 0){
            return false;
        }
        int number = x;
        int result = 0;
        while(number > 0){
            
            long long int temp = result;
            temp = temp * 10;
            if(temp > 2147483647 || temp < 0){
                return false;
            }
            result = result*10;
            result += (number % 10);
            number = number / 10;
        }
        return result - x == 0;
    }
};
