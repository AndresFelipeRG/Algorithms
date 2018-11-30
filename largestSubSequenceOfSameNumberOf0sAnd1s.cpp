#include <bits/stdc++.h>
using namespace std;

int maxLen(int arr[], int n)
{
    int data[n][n][2];
    
    int ones = 0;
    
    for(int i = 0; i < n; i++){
        
        if(arr[i] == 1){
            ones++;
           
        }
        
    }
    int zeros = n - ones;
    int maxLen = min(zeros, ones);
    int maxLenSoFar = 0;
    
    for(int k = 0 ; k < n; k ++){
        
        data[k][k][0] = arr[k] == 0 ? 1: 0;
        data[k][k][1] = arr[k] == 1 ? 1: 0;
        
    }
    
    for(int k = 0 ; k < n-1; k ++){
        
        data[k][k+1][0] = arr[k+1] == 0 ? data[k][k][0] + 1: data[k][k][0];
        data[k][k+1][1] = arr[k+1] == 1 ? data[k][k][1] + 1: data[k][k][1];
           
        
    }

    
    for(int i = 2; i <= 2*maxLen ; i++){
        
        for(int j = 0; j < n-i+1; j++){
            
            int k = j + i - 1;
            data[j][k][0] = arr[k] == 0 ? data[j][k-1][0] + 1: data[j][k-1][0];
            data[j][k][1] = arr[k] == 1 ? data[j][k-1][1] + 1: data[j][k-1][1];
           
            if(data[j][k][0] == data[j][k][1]){
                maxLenSoFar = i;
            }
        }
        
    }
    
    return maxLenSoFar;
    
    

}
