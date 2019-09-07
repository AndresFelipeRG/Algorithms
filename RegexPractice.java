import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

class RegexPractice {
    public static void main(String [] args){
     String all = "";
     Matcher m = Pattern.compile("(http://|https://){1}(www|ww2|web){0,1}([a-z0-9-]+){1}(\\.[a-z0-9-]+){1,}(/){0,}")
     .matcher("adadaaasda322442 saasasaahttp://www.aabsbs.cadda.com/sbbsd/ababs-/13233223https://ww2.felix.elgato3j1i31213.com ");
        while (m.find()) {

          String match = m.group();
          System.out.println(match);
          match = match.replace("http://", "");
          match = match.replace("https://", "");
          int left = 0;
          int right = 0;
          for(int i = 0; i < match.length() ;i++){
                
            if(match.charAt(i) == '/'){
                right = i;
                break;
            }
            right++;
          }
          all = all + match.substring(0, right)+";";
        }
        System.out.println(all);
    }
}
