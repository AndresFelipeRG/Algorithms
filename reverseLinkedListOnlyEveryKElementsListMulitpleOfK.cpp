/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::reverseList(ListNode* A, int B) {
    
    int count = 0;
    ListNode * root = A;
    ListNode * previous= NULL;
    ListNode * lastNode = NULL;
    ListNode * secondLastNode = NULL;
    ListNode * beginning = A;
    if (B== 0 || B== 1){return A;}
    
    while(count < B-1){
        beginning = beginning->next;
        count = count + 1;
    }
    count = 0;
  
  
    while(root-> next != NULL){
        
            
            
            if(count == B-1 ){
                
                ListNode * node =  root->next;
                
                if(lastNode != NULL){
                    
                    lastNode->next = root;
                }
                
               
                lastNode = secondLastNode;
                root->next = previous;
                previous = NULL;
                
                root = node;
                
                count = (count + 1) % B;
            }
            else{
                ListNode * node =  root->next;
                
                if(count == 0){
                    secondLastNode = root;
                }
            
                root->next = previous;
                previous = root;
                root = node;
            
                count = (count + 1) % B;
            }
           
        
    }
    
    root->next = previous;
    if(lastNode != NULL){
                    
         lastNode->next = root;
    }
    
    
    return beginning;
}
