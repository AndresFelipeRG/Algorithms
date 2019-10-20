class Solution {
    public boolean getParentFolder(String folder, Set<String> parents){
        String f = "";
        String [] s = folder.split("/");
       
        if(s.length > 2){
            int count = 1;
            while(count < s.length -1){
                if(parents.contains(f)){
                    return true;
                }
                f= f +"/"+ s[count];
                count += 1;
            }
            if(parents.contains(f)){
                    return true;
            }
        }
        return false;
    }
  
    public List<String> removeSubfolders(String[] folder) {
        
        Set<String> parents = new HashSet<>();
        Map<String, Boolean> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String s: folder){
            
            parents.add(s);
        }
        for(String s: folder){
            
            
            if((getParentFolder(s, parents))){
                map.put(s, false);
            }
            else{
                map.put(s, true);
            }
            
        }
        for(Map.Entry it: map.entrySet()){
            if((boolean)it.getValue() ){
                result.add((String)it.getKey());
            }
        }
        return result;
    }
}
