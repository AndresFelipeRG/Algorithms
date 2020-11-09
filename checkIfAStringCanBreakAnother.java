import java.util.*;

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int k = s2.length();
        String [] aS1 = s1.split("");
        String [] aS2 = s2.split("");
        
        List<List<String>> keysS1 = new ArrayList<>();
       
        for(String a: aS1) {
            List<String> temp = new ArrayList<>();
            temp.add(a);
            temp.add("1");
            keysS1.add(temp);
            
        }
        for(String a: aS2) {
            List<String> temp = new ArrayList<>();
            temp.add(a);
            temp.add("2");
            keysS1.add(temp);
     
        }
        Collections.sort(keysS1, new Comparator<List<String>>() {
    @Override
    public int compare(List<String> o1, List<String> o2) {
        if(o1.get(0).compareTo(o2.get(0)) == 0){
            return o1.get(1).compareTo(o2.get(1));
        }
        return o1.get(0).compareTo(o2.get(0));
    }
});
        //System.out.println(String.valueOf(keysS1));
        String first = "1";
        int count = 0;
        boolean res = true;
        for(int i = keysS1.size()-1; i>=0;i--){
            if(keysS1.get(i).get(1).compareTo(first) == 0){
               
                count--;
            }
            else{
                count++;
            }
            
            if(count< 0){
                res = false;
                break;
            }
        }
        if (res) return true;
        first = "2";
        count = 0;
        res = true;
           Collections.sort(keysS1, new Comparator<List<String>>() {
    @Override
    public int compare(List<String> o1, List<String> o2) {
        if(o1.get(0).compareTo(o2.get(0)) == 0){
            return o2.get(1).compareTo(o1.get(1));
        }
        return o1.get(0).compareTo(o2.get(0));
    }
});
        //System.out.println(String.valueOf(keysS1));
        for(int i = keysS1.size()-1; i>=0;i--){
            if(keysS1.get(i).get(1).compareTo(first) == 0){
               
                count--;
            }
            else{
                count++;
            }
            
            if(count< 0){
                res = false;
                return false;
            }
        }
       
   
        return true;
        
    }
}
