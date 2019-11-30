import java.util.*;

class Solution {
    
    public int maxDistToClosest(int[] seats) {
         
        TreeSet<Integer> map = new TreeSet();
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] != 0) map.add(i);
        }
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0){
                Integer left = map.lower(i);
                Integer right = map.higher(i);
              //  System.out.println("left:"+left);
              //  System.out.println("right:"+right);
               
                if(left != null && right != null){
                    int close = Math.abs(i-left) > Math.abs(i-right)? right: left;
                    ans = Math.max(Math.abs(i-close), ans);}
                else if(right != null) ans = Math.max(ans, Math.abs(i-right));
                else if(left != null)  ans = Math.max(ans, Math.abs(i-left));
              //  System.out.println(ans);
            }
        }
        return ans == Integer.MIN_VALUE ? -1: ans;
    }
}
