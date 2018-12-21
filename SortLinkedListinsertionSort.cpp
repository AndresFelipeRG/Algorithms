/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
struct Tree{
    int val;
    Tree * left;
    Tree * right;
};
void preorder(Tree * root){
    
    if (root != NULL){
        preorder(root->left);
        
        if(root->left!=NULL ){
           
            cout << "-> ";
        }
     
        cout << root->val << " ";
        
        if(root->right!=NULL ){
           
            cout << "-> ";
        }
        preorder(root->right);
       
        
    }
}
void insertNode(Tree * root, ListNode * data){
    
    
    if(root->val <= data->val){
        if(root->right == NULL){
            root->right = new Tree;
            root->right->val = data->val;
            root->right->left = NULL;
            root->right->right = NULL;
        }else{
            insertNode(root->right, data);
            
        }
    }
    if(root->val > data->val){
        if(root->left == NULL){
            root->left = new Tree;
            root->left->val = data->val;
            root->left->right = NULL;
            root->left->left = NULL;
        }else{
            insertNode(root->left, data);
        }
    }
    
}

ListNode* Solution::insertionSortList(ListNode* A) {
    
    Tree * root = new Tree;
    
    root->val = A->val;
    root->left = NULL;
    root->right = NULL;
    
    while(A->next != NULL){
        insertNode(root, A->next);
        A = A->next;     
    }
    preorder(root);
}
