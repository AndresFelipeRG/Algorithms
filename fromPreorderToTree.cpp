struct Node
{
	int data;
	struct Node *left;
	struct Node *right;
};

// function should return the root of the new binary tree formed
Node * recursive(vector<int> * pre, vector <char> * preLN){
    if((*pre).size() == 0 && (*preLN).size() == 0){
        return NULL;
    }
    if((*preLN).front() == 'L'){
        
        Node * node = new Node();
        node->data = (*pre).front();
        node->left = NULL;
        node->right = NULL;
        (*pre).erase((*pre).begin());
        (*preLN).erase((*preLN).begin());
        
        return node;
    }
    int data = (*pre).front();
    
    (*pre).erase((*pre).begin());
    (*preLN).erase((*preLN).begin());
    
    Node * left = recursive( pre, preLN);
    Node * right = recursive(pre, preLN);
    Node * node = new Node();
    node->data = data;
    node->left = left;
    node->right = right;
    return node;
}
struct Node *constructTree(int n, int pre[], char preLN[])
{
    // Code here
    Node * node = new Node();
    vector<int> _pre;
    vector<char> _preLN;
    
    for(int i = 0; i < n; i++){
        _pre.push_back(pre[i]);
    }
    for(int i = 0; i < n; i++){
        _preLN.push_back(preLN[i]);
    }
    

    node = recursive(&_pre,&_preLN);
    
    return node;
}
