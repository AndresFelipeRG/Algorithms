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
    
    public int util(TreeNode node, int prev, int curr){
        
        
        
        if(node == null) return curr;
        
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        
        if(node.val == prev + 1){ 
            right = util(node.right, node.val, curr +1);
            left =  util(node.left, node.val, curr + 1);
            return Math.max(left, right);
        }
        else{
            left = util(node.left, node.val, 1);
            right = util(node.right, node.val, 1);
            return  Math.max(curr, Math.max(left, right));
        }
        
        
    }
    public int longestConsecutive(TreeNode root) {
        
        return util(root, Integer.MIN_VALUE, 0);
        
    }
}
