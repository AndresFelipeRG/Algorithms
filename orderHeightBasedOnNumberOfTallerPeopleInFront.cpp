
struct Tree {
     int height;
     int people;
     Tree *left;
     Tree *right;
      
};

vector<int> buildTree(Tree * node){
    if(node == NULL ){
        vector<int> ret;
        return ret;
    }
    vector<int> result;
    vector<int> left = buildTree(node->left);
    if(left.size()> 0){
        result.insert(result.end(), left.begin(), left.end());
    }
    int element = node->height;
    result.push_back(element);
    vector<int> right = buildTree(node->right);
    if(right.size()> 0){
        result.insert(result.end(), right.begin(), right.end());
    }
    return result;
}

void insertTree(Tree * node, int height, int people){
    if(height < node->height && people > 0 ){
        if(node->right != NULL){
            insertTree(node->right, height, people -1);
        }
        else {
           Tree * nodeN = new Tree();
           nodeN->height = height;
           nodeN->people = people-1;
           nodeN->left = NULL;
           nodeN->right = NULL;
           node->right = nodeN;
        }
    }
    else if(height < node->height && people == 0 ){
        if(node->left != NULL){
            insertTree(node->left, height, people);
        }
        else {
           Tree * nodeN = new Tree();
           
           nodeN->height = height;
           nodeN->people = people;
           nodeN->left = NULL;
           nodeN->right = NULL;
           node->left = nodeN;
        }
    }
    else if(height >= node->height && node->people > 0){
        if(node->left != NULL){
            node->people = node->people -1;
            insertTree(node->left, height, people);
        }
        else {
           node->people = node->people -1;
           Tree * nodeN = new Tree();
           nodeN->height = height;
           nodeN->people = people;
           nodeN->left = NULL;
           nodeN->right = NULL;
           node->left = nodeN;
        }
    }
    else{
        if(node->right!= NULL){
            insertTree(node->right, height, people);
        }
        else {
           Tree * nodeN = new Tree();
           nodeN->height = height;
           nodeN->people = people;
           nodeN->left = NULL;
           nodeN->right = NULL;
           node->right = nodeN;
        }
    }
    
}
vector<int> Solution::order(vector<int> &A, vector<int> &B) {
    
    vector<int> result;
    Tree * root = new Tree();
    if(A.size() > 0 ){
        int height = A[0];
        int people = B[0];
        root->height = height;
        root->people = people;
        for(int i = 1 ; i  < A.size(); i ++){
            insertTree(root, A[i], B[i]);
        }
        result = buildTree(root);
    }
    return result;
}
