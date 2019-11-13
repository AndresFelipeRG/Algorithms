class Solution {
    public int totalFruitUtil(int [] tree, int start, int first, int second, int qte){
        for(int i = start; i < tree.length; i++){
            if(tree[i] != first ){
                if(second == -1){
                    second = tree[i];
                }
                if(tree[i] == second){
                    qte += 1;
                }  
                else{
                    break;
                }
            }
            else{
                qte += 1;
            }
        }
        return qte;
    }
    public int totalFruit(int[] tree) {
        if(tree.length == 0){
            return 0;
        }
        if(tree.length == 1){
            return 1;
        }
        int first = tree[0];
        int second = -1;
        int l = 0;
        int r = 0;
        int qte = 0;
        int last = 0;
        for(int i = 0; i < tree.length; i++){
            if(tree[i] != first){
                
                if(second == -1){
                    second = tree[i];
                    
                }
               
                if(tree[i] != second){
                    
                    qte = Math.max(qte, r-l);
                   // System.out.println(last);
                    l = last;
                    r = i + 1;
                    first = tree[l];
                    second = tree[i];
                    last = i;
                    
                }
                else{
                    if(tree[last] != second){
                        last = i;
                    }
                    qte = Math.max(qte, r-l+1);
                    r+=1;
                }
            }
            else{
                if(tree[last] != first){
                    last = i;
                }
                qte = Math.max(qte, r-l+1);
                r+=1;
            }
        }
        return qte;
    }
}
