/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
vector<vector<int> > recursion(TreeNode * A, int sum){
    
    if(A == NULL){
        vector<vector<int>> empty;
        return empty;
    }
    if(A->left == NULL && A->right == NULL){
        vector<vector<int>> res;
        if(A->val == sum){
            vector<int> append;
            append.push_back(A->val);
            res.push_back(append);
        }
        return res;
    }
    vector<vector<int>> left = recursion(A->left, sum-A->val);
    vector<vector<int>> right = recursion(A->right, sum-A->val);
    
    vector<vector<int>> result;
    if(left.size() > 0 ){
        for(int i = 0; i < left.size(); i++){
            left[i].insert(left[i].begin(), A->val);
        }
        result.insert(result.end(),left.begin(), left.end());
    }
    if(right.size() > 0 ){
        for(int i = 0; i < right.size(); i++){
            right[i].insert(right[i].begin(), A->val);
        }
        result.insert(result.end(),right.begin(), right.end());
    }
    return result;
}
vector<vector<int> > Solution::pathSum(TreeNode* A, int B) {
    return recursion(A, B);
}
