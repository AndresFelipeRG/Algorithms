#include <iostream>
#include <cmath>
#include <climits>
using namespace std;

int main() {
	//code
	int t = 0;
	cin >> t;
	while(t--){
	    int n = 0;
	    cin >> n;
	    int currentSum = 0;
	    int maxSum = INT_MIN;
	    while(n--){
	        int item = 0;
	        cin >> item;
	        currentSum = currentSum + item;
	        if(currentSum > maxSum){
	            maxSum = currentSum;
	        }
	        if(currentSum < 0 ){
	            currentSum = 0;
	        }
	    }
	    cout << maxSum << endl;
	}
	return 0;
}
