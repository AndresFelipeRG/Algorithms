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
    public  int findLeftMost(TreeNode node, int level, int index){
        if(node == null){
            return -1;
        }
        if(level == 0){
            return index;
        }
        if(node.left == null && node.right == null){
            return level == 0 ? index: -1;
        }
        int left = findLeftMost(node.left, level-1, 2*index +1);
        int right = findLeftMost(node.right, level-1, 2*index + 2);
        return left == -1 ?(right): left;
        
    }
    public  int findRightMost(TreeNode node, int level, int index){
        if(node == null){
            return -1;
        }
        if(level == 0){
            return index;
        }
        if(node.left == null && node.right == null){
            return level == 0 ? index: -1;
        }
        int left = findRightMost(node.left, level-1, 2*index +1);
        int right = findRightMost(node.right, level-1, 2*index + 2);
        return right == -1 ?(left): right;
        
    }
    public int findHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }
    public int widthOfBinaryTree(TreeNode root) {
        int levels = findHeight(root);
        int maximum = 0;
        if(levels == 1){
            return 1;
        }
       // System.out.println("levels: "+ levels);
        for(int i = 0; i < levels; i++){
            int distance = 1 +  findRightMost(root, i, 0) - findLeftMost(root, i, 0)                ;
           // System.out.println(distance);
            maximum = maximum < distance? distance: maximum;
            
        }
        
        return maximum;
    }
}
