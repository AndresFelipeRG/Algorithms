/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
int Solution::maxDepth(TreeNode* A) {
    
    if(A == NULL){
        return 0;
    }
    else if(A->left == NULL && A->right == NULL){
        return 1;
    }
    else{
        int depth = max(maxDepth(A->left), maxDepth(A->right));
        return depth + 1;
    }
}
