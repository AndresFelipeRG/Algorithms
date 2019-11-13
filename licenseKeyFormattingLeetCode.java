class Solution {
    public String licenseKeyFormatting(String S, int K) {
        
        String [] aGroups = S.split("-");
        if(aGroups.length == 0){
            return "";
        }
        String sTemp = String.join("",aGroups);
        sTemp = sTemp.toUpperCase();
        String result = "";
        int count = 0;
        for(int i = sTemp.length()-1; i >= 0; i--){
            count += 1;
            result = count == K ? "-"+sTemp.charAt(i)+result: sTemp.charAt(i)+result;
            if(count ==  K){count = 0;}
        }
        result = result.charAt(0) == '-' ? result.substring(1): result;
        return result;
    }
}
