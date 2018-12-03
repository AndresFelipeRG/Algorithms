struct Node
{
    int data;
    Node* left, * right;
}; */
/* Your are required to 
complete this method*/
int recursive(Node * root, int * res){
    
    if(root == NULL){
        return 10000000;
    }
    if(root->left == NULL && root->right == NULL){
        
        return root->data;
        
    }
    
    int minValue = min(recursive(root->left, res), recursive(root->right, res));
    int maxValue = max(*res, root->data-minValue);
    *res = maxValue;
    
    return min(root->data, minValue);
    
    
}
int maxDiff(Node* root)
{
    // Your code here 
    int * maxDiff;
    *maxDiff = -100000;
    
    recursive(root, maxDiff);
    
    
    
    
    return *maxDiff;
}
