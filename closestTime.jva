import java.util.*;
class Solution {
    public int closest(int time , Set<Integer> s, int limit){
       
        int count = (time + 1) % limit;
        while(count != time){
             int b = count %10;
             int a = count/10; 
             if(s.contains(a) && s.contains(b)){
                 break;
             }
             count = (count + 1) % limit;
        }
        return count;
        
    }
    public String nextClosestTime(String time) {
       
        Set<Integer> s = new HashSet<>();
        Integer hours = Integer.valueOf(time.substring(0,2));
        Integer minutes = Integer.valueOf(time.substring(3));
       
        for(char c: time.toCharArray()){
            if(c!=':'){
            s.add(Integer.valueOf(String.valueOf(c)));}
        }
        Integer closeMinutes = closest(minutes, s, 60);
        Integer closeHours = hours;
        if(closeMinutes <= minutes){
                 closeHours = closest(hours, s, 24);
        }
        String sHours = closeHours >= 10? String.valueOf(closeHours): "0"+ String.valueOf(closeHours);
        String sMinutes = closeMinutes  >= 10 ? String.valueOf(closeMinutes ): "0" + String.valueOf(closeMinutes );
        return sHours+":"+sMinutes;  
    }
}
