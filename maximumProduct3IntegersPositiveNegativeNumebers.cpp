//o(n) running time, o(1) constant time
// A O(n) C++ program to find maximum product pair in 
// an array. 
#include <bits/stdc++.h>
using namespace std;

/* Function to find a maximum product of a triplet 
in array of integers of size n */

int maxProduct(int arr [], int n){

   if(n <3){
   return -1;}
  
   int maxA = INT_MIN, maxB = INT_MIN, maxC = INT_MIN;
   int minA = INT_MAX, minB = INT_MAX;
  
   for(int i = 0; i< n; i++){
   
   		if(arr[i] > maxA){
        	maxC = maxB;
            maxB = maxA;
            maxA = arr[i];
        }
        else if(arr[i] > maxB){
            maxC = maxB;
            maxB = arr[i];
        }
        else if(arr[i] > maxC){
        	maxC = arr[i];
        }
     
        if(arr[i] < minA){
            minB = minA;
        	minA = arr[i];
        }
        else if(arr[i] < minB){
           minB = arr[i];
        }
     
   }
   return max(maxA*maxB*maxC, minA*minB*maxA);
}

// Driver program to test above function 
int main() 
{ 
	int arr[] = { 1, -4, 3, -6, 7, 0 }; 
	int n = sizeof(arr) / sizeof(arr[0]); 

	int max = maxProduct(arr, n); 

	if (max == -1) 
		cout << "No Triplet Exists"; 
	else
		cout << "Maximum product is " << max; 

	return 0; 
} 
