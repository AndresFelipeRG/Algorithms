**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
int traverse(TreeNode* A, int B, int C, bool & condition){
    
    if(A == NULL){
        return -1;
    }
    if(A ->val == B && (A->left == NULL && A->right == NULL )){
        if(B == C){
            condition = true;
        }
        return B;
    }
    if(A ->val == C && (A->left == NULL && A->right == NULL )){
         if(B == C){
            condition = true;
        }
        return C;
    }
    if(A->val == B && A->val == C){
        condition = true;
        return A->val;
    }
    
    int left = traverse(A->left, B, C, condition);
    int right = traverse(A->right, B, C, condition);
    
    if(A->val == B){
        if(left == C || right == C){
            condition = true;
        }
        return A->val;
    }
    
    if(A->val == C){
        if(left == B || right == B){
            condition = true;
        }
        return A->val;
    }
    
   
    if((left == B && right == C) || (left == C && right == B)){
        condition = true;
        return A->val;
    }
    
    
    return max(left, right);
}

int Solution::lca(TreeNode* A, int B, int C) {
    
    bool condition = false;
    int result = traverse(A, B, C, condition);
    
    if(condition){
        return result;
    }
    
    return -1;
    
    
    
    
}
