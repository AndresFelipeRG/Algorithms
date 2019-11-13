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
       
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < tree.length; i++){
          
            res = Math.max(res, totalFruitUtil(tree,i, tree[i], -1, 0 ));
        }
        return res > Integer.MIN_VALUE ? res: 0;
    }
}
