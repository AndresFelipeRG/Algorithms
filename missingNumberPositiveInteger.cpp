// t -> number of test cases
// n  
//1 2 3.. n -> 1 to n numbers. A number is missing so there are n-1 numbers.
#include <iostream>
using namespace std;

int main() {
	//code
	int t = 0;
	cin >> t;
	while(t--){
	    int n = 0;
	    cin >> n;
	 
	    int sum = ((n)*(n+1))/2;
	    int cSum = 0;
	    n = n - 1;
	    while(n--){
	        int item = 0;
	        cin >> item;
	        cSum += item;
	    }
	    int missingNumber = sum - cSum;
	    
	    cout << missingNumber << endl;
	}
	return 0;
}
