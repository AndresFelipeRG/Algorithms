
class Solution {
   
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        //4t, 1c -> B
        //2t, 1c -> S
        //#C = B + S
        //4B+ 2S = T
        //T - C = 3B + S
        //1->N
        int n = cheeseSlices;
        List<Integer> ans = new ArrayList<>();
        if(n == 0 && tomatoSlices == 0) { ans.addAll(Arrays.asList(0, 0)); return ans;} 
        if(n < 1 || tomatoSlices < n || tomatoSlices < 2) return ans;
        int c = tomatoSlices - cheeseSliaces;
        if( c < 1 ) return ans;
        
        for(int i = 1; i <= n;i++){
            if(((c-i) % 3 == 0 && (c-i)/3 + i == n)){ ans.addAll(Arrays.asList((c-i)/3,i)); return ans;}
        }
        
        return ans;
    }
}
