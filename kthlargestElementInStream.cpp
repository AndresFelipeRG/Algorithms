#include <iostream>
#include <bits/stdc++.h>
using namespace std;


int main() {
    
	int t;
	cin >> t;
	
	while(t--){
	    priority_queue<int, vector<int>, greater<int>> pq;
	    priority_queue<int> pq_max;
	
	    int n, k;
	    cin >> k >> n;
	    int i = 0;
	    for(i = 0; i < n ; i++){
	        
	        int element;
	        int k_largest;
	        cin >> element;
	        
	        if(pq.size() == k - 1){
	            
	                
	                pq.push(element);
	                cout << pq.top() << " ";
	            
	        }
	        else if(pq.size() >= k){
	            
	            if(element >= pq.top()){
	                
	                int removed_element = pq.top();
	                pq.pop();
	                pq.push(element);
	                k_largest = pq.top();
	                pq_max.push(removed_element);
	                cout << k_largest << " ";
	            }
	            else{
	                
	                pq_max.push(element);
	                cout << pq.top() << " ";
	                
	            }
	            
	        }
	        else{
	            pq.push(element);
	            
	            cout << "-1 " ; 
	        }
	        
	    }
	    
	    
	    cout << endl;
	    
	}
	
	return 0;
	
}
