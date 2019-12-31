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
    public int deepestLevel(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(deepestLevel(root.left), deepestLevel(root.right)) ;
    }
    public int sumDeepestLevel(TreeNode node, int level){
        if(node.left == null && node.right == null && level == 1) return node.val;
        if(node.left == null && node.right == null && level > 0) return -1;
        int sum = 0;
        int left = node.left != null ? sumDeepestLevel(node.left, level - 1): 0;
        if(left > 0) sum += left;
        int right = node.right !=null ? sumDeepestLevel(node.right, level-1): 0;
        if(right > 0) sum += right;
        return sum;
        
    }
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        int level = deepestLevel(root);
        int ans = sumDeepestLevel(root, level);
        System.out.println(ans);
        
        return ans;
    }
}
