class Program {
	public static boolean isPalindrome(String str, int l, int r){
			boolean sol = true;
			while(l <= r){
				if(str.charAt(l) != str.charAt(r)){
					return false;
				}
				l++;
				r--;
			}
			return sol;
	}
	public static int[] palindrome(int l, int r, String str){
		while(l >= 0 && r < str.length()){
			if(str.charAt(l) != str.charAt(r)){
				break;
			}
			l--;
			r++;
		}
		
		return new int[] {++l, r-l};
	}
  public static String longestPalindromicSubstring(String str) {
    // Write your code here.

		
		int [] longest = {0,1}; 
		
		
		for(int i = 1; i < str.length(); i++){
			 
			  int [] odd = palindrome(i-1, i+1, str);
			  int [] even = palindrome(i-1, i, str);
			  int [] current = odd[1] > even[1] ? odd: even;
			
			  longest = current[1] > longest[1] ? current: longest;
		}
		
		return str.substring(longest[0], longest[1]+longest[0]);
  }
}
