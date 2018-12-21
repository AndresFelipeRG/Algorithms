**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */


int Solution::lPalin(ListNode* A) {
    
   
    ListNode * root = A;
    ListNode * compare = A;
   
   
    if(A == NULL){
        return 0;
    }
    
    if(A->next == NULL){
        return 1;
    }
    ListNode * beginning = new ListNode(A->val);
    beginning->next = NULL;
    
    while(root->next != NULL){
        
        ListNode * node = new ListNode(root->next->val);
        node->next = beginning;
        beginning = node;
        root = root->next;
    }
    
    while(compare != NULL){
        
        if(compare->val != beginning->val){
            return 0;
        }
        compare = compare->next;
        beginning = beginning->next;
        
    }

   return 1;
   
    
}
