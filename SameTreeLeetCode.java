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
    
    public String inOrder(TreeNode p){
        if(p == null){
            return "null";
        }
        if(p.left == null && p.right == null){
            return String.format("%d", p.val);
        }
        String left = inOrder(p.left);
        String root = String.format("%d",p.val);
        String right = inOrder(p.right);
        return left+root+right;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        String resP = inOrder(p);
        String resQ = inOrder(q);
        //System.out.println(resP);
        //System.out.println(resQ);
        return  resP.equals(resQ);
    }
}
