int Solution::maxProduct(const vector<int> &A) {
   
    
    int minEndingHere = 1;
    int maxEndingHere = 1;
    int maxSoFar = 1;
    
    for(int i = 0; i < A.size(); i++){
        if(A[i] < 0){
            int temp = maxEndingHere;
            maxEndingHere = max(minEndingHere*A[i], 1);
            minEndingHere = temp*A[i];
        }
        if(A[i] == 0){
            minEndingHere = 1;
            maxEndingHere = 1;
        }
        if(A[i] > 0 ){
            maxEndingHere = maxEndingHere*A[i];
            minEndingHere = min(minEndingHere*A[i], 1);
        }
        if(maxEndingHere > maxSoFar){
             maxSoFar = maxEndingHere;
         }
    }
    
    if(maxSoFar == 1){
        
        for(int i = 0; i < A.size(); i++){
            if(A[i]  == 1){
                return 1;
            }
        }
        return 0;
    }
    
    
    return maxSoFar;
    
}
