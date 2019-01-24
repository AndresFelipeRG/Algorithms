#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
	//code
	
	int n;
	
	cin >> n;
	
	priority_queue<int> pq_max;
	priority_queue<int, vector<int>, greater<int>> pq_min;
	
	while(n--){
	    
	    int element;
	    
	    cin >> element;
	    
	    
	    if(pq_max.size() == 0){
	        
	        pq_max.push(element);
	        cout << element;
	        
	    }else if(pq_max.top() < element && pq_min.size() < pq_max.size()){
	       
	        
	        pq_min.push(element);
	        cout << (pq_max.top()+pq_min.top())/2;
	        
	    }else if(pq_max.top() < element && pq_min.size() > pq_max.size()){
	        
	        int removed = pq_min.top();
	        if(removed < element){
	             pq_min.pop();
	             pq_min.push(element);
	             pq_max.push(removed);
	       
	        }else{
	             pq_max.push(element);
	        }
	        cout << (pq_max.top()+pq_min.top())/2;
	        
	    }else if(pq_max.top() == element && pq_min.size() < pq_max.size()){
	       
	        
	        pq_min.push(element);
	        cout << (pq_max.top()+pq_min.top())/2;
	        
	    }else if(pq_max.top() == element && pq_min.size() > pq_max.size()){
	        
	        int removed = pq_min.top();
	        if(removed < element){
	             pq_min.pop();
	             pq_min.push(element);
	             pq_max.push(removed);
	       
	        }else{
	             pq_max.push(element);
	        }
	        cout << (pq_max.top()+pq_min.top())/2;
	        
	    }else if(pq_max.top() > element && pq_min.size() < pq_max.size()){
	       
	        int removed = pq_max.top();
	      
	        pq_max.pop();
	        pq_max.push(element);
	        pq_min.push(removed);
	        cout << (pq_max.top()+pq_min.top())/2;
	        
	    }else if(pq_max.top() > element && pq_min.size() > pq_max.size()){
	        
	        pq_max.push(element);
	        cout << (pq_max.top()+pq_min.top())/2;
	        
	    }else if(pq_max.top() > element && pq_min.size() == pq_max.size()){

	        pq_max.push(element);
	        cout << pq_max.top();
	        
	    }else if(pq_max.top() < element && pq_min.size() == pq_max.size()){
	     
	        pq_min.push(element);
	        cout << pq_min.top();
	        
	    }else if(pq_max.top() == element && pq_min.size() == pq_max.size()){
	     
	        pq_max.push(element);
	        cout << pq_max.top();
	        
	    }
	   
	   cout << endl;
	    
	    
	}
	return 0;
}
