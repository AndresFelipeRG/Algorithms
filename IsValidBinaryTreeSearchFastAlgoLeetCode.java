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
     public boolean helper(TreeNode root, long min, long max) {
        if(root == null){
            return true;
        }
        int val = root.val;
        if( val<= min){
            return false;
        }
        if( val >= max){
            return false;
        }
        if(!(helper(root.left, min, val))){
            return false;
        }
        if(!(helper(root.right, val, max))){
            return false;
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
       
        if(root == null ){
            return true;
        }
       
        return helper(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
