/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::reverseBetween(ListNode* A, int B, int C) {
    
    ListNode * root = A;
    ListNode * compare = A;
    ListNode * result = A;
    ListNode * nodeB = NULL;
    ListNode * nodeC = NULL;
    ListNode * nodeCB = NULL;
    int count = 1;
   
   
    if(A == NULL){
        return NULL;
    }
    
    if(A->next == NULL){
        return A;
    }
    if(B == C){
        return A;
    }
    
   
    
    while(root != NULL){
        
        if(count == B - 1){
            nodeB = root;
         }
         if(count == C + 1){
             
            nodeC = root;
         }
       root = root->next;
       count++;
       
    }
    
    count = 1;
    ListNode * beginning = NULL;
    
    while(compare != NULL && count <= C){
        
        if(count == B){
            
            beginning = new ListNode(compare->val);
            beginning->next = nodeC;
        }
        if(count == C){
            nodeCB = compare;
        }
        if(count > B && count <= C){
            
            ListNode * node = new ListNode(compare->val);
            node->next = beginning;
            beginning = node;
            
        }
        count++;
        compare = compare->next;
        
        
    }
    
    if(nodeB != NULL){
        nodeB->next = beginning;
    }
    
    
    return nodeB == NULL ? beginning: result;
    
}
