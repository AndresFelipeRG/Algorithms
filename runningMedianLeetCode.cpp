class MedianFinder {
    
    priority_queue<int> pq_max;
	priority_queue<int, vector<int>, greater<int>> pq_min;
    double median;
    
public:
    /** initialize your data structure here. */
    MedianFinder() {
        median = 0.0;
    }
    
    void addNum(int element) {
        if(pq_max.size() == 0){
	        
	        pq_max.push(element);
            median = element;
	        
	    }else if(pq_max.top() <= element && pq_min.size() < pq_max.size()){
	       
	        pq_min.push(element);
	        median = (pq_max.top()+pq_min.top())/2.0;
	        
	    }else if(pq_max.top() <= element && pq_min.size() > pq_max.size()){
	        int removed = pq_min.top();
            if(removed < element){
                pq_min.pop();
                pq_min.push(element);
                pq_max.push(removed);
                median = (pq_max.top()+pq_min.top())/2.0;
            }else{
	            pq_max.push(element);
	            median = (pq_max.top()+pq_min.top())/2.0;
            }
	        
	    }else if(pq_max.top() > element && pq_min.size() < pq_max.size()){
	       
	        int removed = pq_max.top();
	      
	        pq_max.pop();
	        pq_max.push(element);
	        pq_min.push(removed);
	        median = (pq_max.top()+pq_min.top())/2.0;
	        
	    }else if(pq_max.top() > element && pq_min.size() > pq_max.size()){
	        
	        pq_max.push(element);
	        median = (pq_max.top()+pq_min.top())/2.0;
	        
	    }else if( pq_min.size() == pq_max.size()){
            if(pq_max.top() >= element){
	            pq_max.push(element);
	            median = pq_max.top();
            }else{
                pq_min.push(element);
	            median = pq_min.top();
            }
	        
	    }
    }
    
    double findMedian() {
        return median;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
