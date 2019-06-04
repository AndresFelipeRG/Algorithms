#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
	//code
	int t;
	cin >> t;
	while(t--){
	    int n;
	    int s;
	    cin >> n>>s;
	    int k = n;
	    vector<int>array;
	    while(n--){
	        int item;
	        cin >> item;
	        array.push_back(item);
	    }
	    int i = 0;
	    int currentSum = 0;
	    int left = 0;
	    int right = 0;
	    bool found = false;
	    while(i <= k){
	       // cout << left + 1 << " " << right << endl;
	        if(currentSum == s){
	            cout << left + 1 << " " << right << endl;
	            found = true;
	            break;
	        }
	        if(currentSum > s){
	            currentSum = currentSum - array[left];
	            left = left +1;
	            continue;
	        }
	        if(currentSum < s){
	            if(i < k){
	            currentSum = currentSum + array[i];
	            }
	            i = i + 1;
	            right = right + 1;
	        }
	        
	    }
	    if(!found){
	        cout << -1 << endl;
	    }
	    
	}
	return 0;
}
