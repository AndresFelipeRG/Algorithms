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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        else{
            if(root.right != null && root.left != null){
                return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
            }
            if(root.right != null){
                return 1 + maxDepth(root.right);
            }
            return 1 + maxDepth(root.left);
        }
    }
}
