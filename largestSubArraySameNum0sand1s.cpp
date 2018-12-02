int maxLen(int arr[], int n)
{
    int sum[n];
    
    sum[0] = arr[0] == 0 ? -1 : 1;
    int minimum = arr[0];
    int maximum = arr[0];
    for(int i = 1; i < n; i++){
        
        sum[i] = sum[i-1] + ((arr[i] == 0) ? -1 : 1);
        
        if(sum[i] > maximum){
            maximum = sum[i];
        }
        if(sum[i] < minimum){
            minimum = sum[i];
        }
    }
    
    int hash[maximum-minimum + 1];
    for(int i = 0; i < maximum-minimum + 1; i++){
        hash[i] = -1;
    }
    
 
    int maxLen = 0;
    for(int i = 0 ; i < n ; i++){
        
        if(sum[i] == 0){
            
            maxLen = i + 1;
        }
        
        else if(hash[sum[i]-minimum] == -1){
            hash[sum[i]-minimum] = i;
        }
        else {
            if(i-hash[sum[i]-minimum] > maxLen){
               maxLen =  i-hash[sum[i]-minimum];
            }
            
        }
        
        
    }
    
    return maxLen;
 
}
