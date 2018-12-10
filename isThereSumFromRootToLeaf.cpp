/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

bool addTraverse(TreeNode * A, int sum){
    if(A == NULL){
        return false;
    }
    if(A->left == NULL && A->right == NULL){
        return A->val == sum;
    }
    
    bool left = addTraverse(A->left, sum-A->val);
    bool right = addTraverse(A->right, sum-A->val);
    return left || right;
}
int Solution::hasPathSum(TreeNode* A, int B) {
    
    int ans = addTraverse(A, B) ? 1: 0;
    
    return ans;
}
