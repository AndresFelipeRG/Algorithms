import java.util.*;
class Solution {
    
    public int maxLength(List<String> arr) {
        if(arr.size() == 0){
            return 0;
        }
        if(arr.size() == 1){
            return arr.get(0).length();
        }
        int curMax = 0;
        for(int i = 0; i < arr.size(); i++){
            curMax = Math.max(dfs(arr, i, arr.get(i)), curMax);
        }
        return curMax;
        
    }
    public int dfs(List<String> arr, int index, String path){
        if(index >= arr.size() || arr.size() == 0){
            return 0;
        }
        boolean unique = isUniqueChars(path);
        if(!unique){
            return 0;
        }
        int currMax = path.length();
        for(int i = index+1; i < arr.size(); i++){
            String sPath = path + arr.get(i);
            int nMax = dfs(arr, i, sPath);
            currMax = Math.max(nMax, currMax);
        }
        return currMax;
    }
    public boolean isUniqueChars(String path){
        Set<Character> s = new HashSet<>();
        for(char c: path.toCharArray()){
            if(s.contains((Character) c)){
                return false;
            }
            s.add((Character) c);
        }
        return true;
    }
}
