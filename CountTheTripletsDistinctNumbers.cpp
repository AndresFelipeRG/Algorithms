//Input 
// t <- test cases
// n <- lenght
// a b c d e f <- distinct numbers and positive
#include <iostream>
#include <bits/stdc++.h>
#include <algorithm>
using namespace std;

int main() {
	//code
	int t = 0;
	cin >> t;
	while(t--){
	    int n = 0;
	    int triplets = 0;
	    cin >> n;
	    vector<int> items;
	    unordered_set<int> numbers;
	    int length = n;
	    while(n--){
	        int item;
	        cin >> item;
	        numbers.insert(item);
	        items.push_back(item);
	    }
	    sort(items.begin(), items.end());
	    for (int i = 2; i < length; i++){
	        for(int j = 0; j < i; j ++){
	            int missingNumber = items[i] - items[j];
	            if(missingNumber > items[j]){
	                if(numbers.find(missingNumber) != numbers.end()){
	                    triplets = triplets + 1;
	                }
	            }
	        }
	    }
	    if(triplets > 0){
	        cout << triplets << endl;
	    }
	    else{
	        cout << -1 << endl;
	    }
	}
	return 0;
}
