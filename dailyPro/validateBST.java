import java.util.*;
class Program {
	public static boolean utilValidateBst(BST tree, int min, int max){
		 if(tree == null){
			 return true;
		 }
		 if(tree.value >= max || tree.value < min){
				 return false;
		 }
		 else{
			 boolean valid = true;
			 if(tree.left != null){
				  valid = utilValidateBst(tree.left, min, tree.value);
			    if(valid == false){
						return false;
					}
			 }
			 if(tree.right != null){
				 valid = valid && utilValidateBst(tree.right, tree.value, max);
			 }
			 return valid;
		 }
		
	}
  public static boolean validateBst(BST tree) {
    // Write your code here.
			boolean res = utilValidateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
 		
			return res;
	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
