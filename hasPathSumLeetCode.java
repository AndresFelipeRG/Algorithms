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
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result = false;
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
             return sum - root.val == 0;
        }
        if(root.right != null){
            result = hasPathSum(root.right, sum - root.val );
        }
        if(root.left != null){
            result = result || hasPathSum(root.left, sum - root.val);
        }
        return result;
    }
}
