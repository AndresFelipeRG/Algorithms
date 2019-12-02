class Solution {
    public String tictactoe(int[][] moves) {
        
        Set<Set<Integer>> wins = new HashSet<>();
        
        Set<Integer> diag = new HashSet<>();
        Set<Integer> adiag = new HashSet<>();
        for(int i = 0; i < 3; i++){
             Set<Integer> wr = new HashSet<>();
             for(int j = 0; j < 3;j++){
                   wr.add(i*3 + j);
                   if(i-j == 0) diag.add(i*3 + j);
                   if(i+j == 2) adiag.add(i*3 + j);
             }
             wins.add(wr);
            
        }
        
        for(int j = 0; j < 3;j++){
             Set<Integer> wc = new HashSet<>();
             for(int i = 0; i < 3; i++){
                 wc.add(i*3 + j);
             }
             wins.add(wc);
           
        }
        
        wins.add(diag);
        wins.add(adiag);
       // System.out.println(String.valueOf(wins));
        
        Set<Set<Integer>> draw = new HashSet<>();
        Set<Integer> pa = new HashSet<>();
        Set<Integer> pb = new HashSet<>();
        
        int m = 0;
        for(int i = 0; i < moves.length; i+=2){
            pa.add(moves[i][0]*3 + moves[i][1]);
            m++;
        }
        for(int i = 1; i < moves.length; i+=2){
            pb.add(moves[i][0]*3 + moves[i][1]);
            m++;
        }
      //  System.out.println(String.valueOf(pa));
      //  System.out.println(String.valueOf(pb));
        for(Integer i : pa){
            Set<Integer> copy = new HashSet<>();
            copy.addAll(pa);
            copy.remove(i);
            if(copy.size() > 3){
                for(Integer j: pa){
                    if(i != j ){
                         copy.remove(j);
                         if(wins.contains(copy)) return "A";
                         copy.add(j);
                    }
                    
                }
            }
            if(wins.contains(copy)|| wins.contains(pa)) return "A";
        
        }
        for(Integer i: pb){
            Set<Integer> copy = new HashSet<>();
            copy.addAll(pb);
            copy.remove(i);
            if(copy.size() > 3){
                for(Integer j: pb){
                    if(i != j ){
                         copy.remove(j);
                         if(wins.contains(copy)) return "B";
                         copy.add(j);
                    }
                }
            }
            if(wins.contains(copy) || wins.contains(pb)) return "B";
      
        }
        if(m == 9) return "Draw";
        return "Pending";
    }
}

