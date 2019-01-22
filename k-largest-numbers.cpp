#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
    int t;
    cin >> t;
    while(t--){
        
        int n, k;
        cin >> n >> k;
        priority_queue<int> pq;
        while(n--){
            int element;
            cin >> element;
            pq.push(element);
        }
        while(k--){
            cout << pq.top() << " ";
            pq.pop();
        }
        
        cout << endl;
        
    }

	
	return 0;
}
