
//input is a binary number. The goal is to find number of flips to get to the target number from the number 0. 
//When a digit is flipped, all the digits to the right are flipped too. 
class Test{

public static int minFlips(String num){
        if(target.length() == 0){
            return 0;
        }
        int ans = 0;
      
        char current = '0';
        for ( int i = 0; i < target.length(); i++){
            if(target.charAt(i)!= current){
                ans+=1;
                current = target.charAt(i);
            }
        }
        return ans;

}
public static void main(String []args){
        System.out.println(minFlips("1010100111"));
}
}
