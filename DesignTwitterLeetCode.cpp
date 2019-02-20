class Twitter {
public:
    int * count;
    map<int, int> * mapId;
    map<int, priority_queue<int>* > * maps;
    map<int, set<int>*> * myFollowers;
    /** Initialize your data structure here. */
    Twitter() {
        count = new int;
        *count = 0;
        mapId = new map<int, int>;
        maps = new map<int,priority_queue <int>*>;
        myFollowers = new map<int, set<int>*>;
    }
    
    /** Compose a new tweet. */
    void postTweet(int userId, int tweetId) {
    
       
        if(maps->find(userId) == maps->end()){
            (*mapId)[*count] = tweetId;
            (*maps)[userId] = new priority_queue<int>;
            (*maps)[userId]->push(*count);
            
            (*count)++;
             
        }
        else{
            (*mapId)[*count] = tweetId;
            (*maps)[userId]->push(*count);
             vector<int>::iterator it;
           
            (*count)++;
        }
        
    }
     vector<int> getNewsFeedTen(int userId){
        vector<int> tweetsV;
       
        if((*maps).find(userId) != (*maps).end()){
        priority_queue<int> * tweets = (*maps)[userId];
        int i = 0;
        while(i < 10 && tweets->size() > 0){
            tweetsV.push_back(tweets->top());
           
            tweets->pop();
            i++;
        }
        int j = 0;
        while(j < tweetsV.size()){
            tweets->push(tweetsV[j]);
            j++;
        }
        }
        return tweetsV;
     }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    vector<int> getNewsFeed(int userId) {
        priority_queue<int> ids;
        vector<int> data = getNewsFeedTen(userId);
        vector<int>::iterator it;
        set<int>::iterator it2;
        for(it = data.begin(); it != data.end(); it++){
            ids.push(*it);
        }
        if((*myFollowers).find(userId) != (*myFollowers).end()){
        set<int> * followers = (*myFollowers)[userId];
        for(it2 = followers->begin(); it2 != followers->end(); it2++){
             vector<int> data = getNewsFeedTen(*it2);
             vector<int>::iterator iter;
             for(iter = data.begin(); iter != data.end(); iter++){
                ids.push(*iter);
             }
        }
        }
        vector<int> result;
        int i = 0;
        while(i < 10 && ids.size() > 0){
            
            result.push_back((*mapId)[ids.top()]);
            ids.pop();
            i++;
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    void follow(int followerId, int followeeId) {
            
            if(followerId != followeeId){
            if((*myFollowers).find(followerId) == (*myFollowers).end()){
                
                (*myFollowers)[followerId] = new set<int>;
               
            }
             (*myFollowers)[followerId]->insert(followeeId);
            }
            
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    void unfollow(int followerId, int followeeId) {
        if(followerId != followeeId){
          if((*myFollowers).find(followerId) != (*myFollowers).end()){
         
                
                     (*myFollowers)[followerId]->erase(followeeId);
                    
                 
            
          }
        }
    }
};

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * vector<int> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
