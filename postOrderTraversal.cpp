/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
vector<int> Solution::postorderTraversal(TreeNode* A) {
    
    if(A == NULL){
        
        vector<int> ret;
        return ret;
    }
    else if(A->left == NULL && A->right == NULL){
        vector<int> ret;
        ret.push_back(A->val);
        return ret;
    }
    else{
        vector<int> left = postorderTraversal(A->left);
        vector<int> right = postorderTraversal(A->right);
        vector<int> ret;
        if(left.size() > 0){
            ret.insert(ret.end(), left.begin(), left.end());
        }
        if(right.size() > 0 ){
            ret.insert(ret.end(), right.begin(), right.end());
        }
        ret.push_back(A->val);
        return ret;
        
    }
}
