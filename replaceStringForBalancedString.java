class Solution {
    public int balancedString(String s) {
        int [] count = new int[128];
        int n = s.length();
        int sol = n;
        for(int i = 0; i < n;i++){
            ++count[s.charAt(i)];
        }
        int l = 0 ;
        for(int i= 0; i < n;i++){
            --count[s.charAt(i)];
            while(l < n && count['Q']<= n/4&& count['W']<= n/4&& count['E']<= n/4&& count['R']<= n/4){
                
                sol = Math.min(sol, i - l + 1 );
                ++count[s.charAt(l++)];
            }
            
        }
        return sol;
    }
}
