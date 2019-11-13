import java.util.*;
import java.util.regex.*;

class Solution {
    
    public int numUniqueEmails(String[] emails) {
        
        
        Set<String> addressesSet = new HashSet<>();
        
        for(String email: emails){
            
            String [] aEmail = email.split("@");
            String domain = aEmail[1];
            String localName = aEmail[0].replaceAll("\\.", "");
            int indexPlusSign = localName.indexOf('+');
            localName = indexPlusSign >= 0 ? localName.substring(0, indexPlusSign ): localName;
            String sAddress = localName + "@" + domain;
            addressesSet.add(sAddress);
            
        }
        
        return addressesSet.size();
    }
}
