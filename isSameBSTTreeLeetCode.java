/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public String preOrderLeft(TreeNode root){
        if(root == null){
            return "null";
        }
        if(root.left == null && root.right == null){
            return ""+root.val; 
        }
        String left = preOrderLeft(root.left);
        String right = preOrderLeft(root.right);
        return ""+root.val+left+right;
    }
    public String preOrderRight(TreeNode root){
        if(root == null){
            return "null";
        }
        if(root.left == null && root.right == null){
            return ""+root.val; 
        }
        String left = preOrderRight(root.left);
        String right = preOrderRight(root.right);
        return ""+root.val+right+left;
    }
    public String inOrderLeft(TreeNode root){
        if(root == null){
            return "null";
        }
        if(root.left == null && root.right == null){
            return ""+root.val; 
        }
        String left = inOrderLeft(root.left);
        String right = inOrderLeft(root.right);
        return left+root.val+right;
    }
    public String inOrderRight(TreeNode root){
        if(root == null){
            return "null";
        }
        if(root.left == null && root.right == null){
            return ""+root.val; 
        }
        
        String right = inOrderRight(root.right);
        String left = inOrderRight(root.left);
        return right+root.val+left;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
      
        boolean preOrder = preOrderLeft(root.left).equals(preOrderRight(root.right));
        return preOrder;
    }
}
