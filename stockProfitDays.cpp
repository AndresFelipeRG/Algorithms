#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <bits/stdc++.h>
using namespace std;

void solve(vector<int> arr){
    int _currMin = 0;
    int _currMax = 0;
    map<int,int> pairs;
    
    for(int i = 0; i < arr.size(); i++){
        
        if(arr[i] > arr[_currMax]){
            
                _currMax = i;
               
                
        }
        else if(arr[i] < arr[_currMax]){
            
            if(_currMin != _currMax){
                pairs[_currMin] = _currMax;
            }
            
            _currMax = i;
            _currMin = i;
        }
    }
    if(_currMin != _currMax){
                pairs[_currMin] = _currMax;
            }
    map<int, int>::iterator it;
    for(it = pairs.begin(); it != pairs.end(); it++){
        cout << "(" << it->first << " " << it->second << ") ";
    }
    if(pairs.size() == 0){cout << "No Profit";}
    cout << endl;
}
int main() {
	//code
	int n;
	cin >> n;
	while(n--){
	    int k;
	    vector<int> arr;
	    cin >> k;
	    for(int i = 0; i < k; i++){
	        int element;
	        cin >> element;
	        arr.push_back(element);
	    }
	    
	    solve(arr);
	    
	}
	return 0;
}
