/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
vector<int> Solution::preorderTraversal(TreeNode* A) {
    
    if(A == NULL){
        vector<int> data;
        return data;
    }
    else if(A->left == NULL && A->right == NULL){
        vector<int> ret;
        ret.push_back(A->val);
        return ret;
    }
    else{
        int data = A->val;
        vector<int> data_vec;
        data_vec.push_back(data);
        vector<int> left = preorderTraversal(A->left);
        vector<int> right = preorderTraversal(A->right);
        
        if(left.size() > 0){
            data_vec.insert(data_vec.end(), left.begin(), left.end());
        }
       
        if(right.size() > 0){
            data_vec.insert(data_vec.end(), right.begin(), right.end());
        }
        return data_vec;
        
    }
    
}
