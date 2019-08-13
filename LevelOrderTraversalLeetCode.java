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
    
    public List<Integer> inorder(TreeNode root, int level, int maxLevel){
        
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            List<Integer> lst = new ArrayList<Integer>();
            lst.add(root.val);
            return level==maxLevel? lst: null;
        }
        List<Integer> left = inorder(root.left, level+1, maxLevel);
        List<Integer> right = inorder(root.right, level+1, maxLevel);
        if(level == maxLevel){
            List<Integer> middle = new ArrayList<Integer>();
            middle.add(root.val);
            if(left != null){
                left.addAll(middle);
                if(right!=null){
                     left.addAll(right);
                }
                return left;
            }
            if(right != null){
                middle.addAll(right);
                return middle;
            }
            return middle;
        }
        if(left!=null){
            if(right!=null){
               left.addAll(right);
            }
            return left;
        }
        return right;   
    }
    public int maxHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = 1+maxHeight(root.left);
        int right =1+ maxHeight(root.right);
        return Math.max(left,right);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        int height = maxHeight(root);
       
        List<List<Integer>> res2 = new ArrayList<>();
        for(int i = 0; i < height; i++){
            List<Integer> res = inorder(root, 0, i);
            res2.add(res);
        }
        return res2;
    }
}
