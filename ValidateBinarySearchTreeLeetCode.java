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
     public boolean isValidMinBST(TreeNode root, int min) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null ){
            return root.val > min;
        }
        return root.val > min ? true && isValidMinBST(root.right, min) && isValidMinBST(root.left, min): false;
    }
     public boolean isValidMaxBST(TreeNode root, int max) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null ){
            return root.val < max;
        }
        return root.val < max ? true && isValidMaxBST(root.left, max) && isValidMaxBST(root.right, max): false;
    }
    public boolean isValidBST(TreeNode root) {
       
        if(root == null ){
            return true;
        }
        boolean left = isValidMaxBST(root.left, root.val);
        boolean right = isValidMinBST(root.right, root.val);
        boolean res = isValidBST(root.left) && isValidBST(root.right);
        return left && right && res;
    }
}
