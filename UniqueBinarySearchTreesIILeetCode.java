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
    public List<TreeNode> createTrees(TreeNode n, int number){
        if(n.right != null && n.left != null){
            
            List<TreeNode> result = new ArrayList<TreeNode>();
            
            List<TreeNode> right = createTrees(n.right, number);
            for(int i = 0; i < right.size(); i++){
                TreeNode node = new TreeNode(n.val);
                node.left = n.left;
                node.right = right.get(i);
                result.add(node);
            }
            TreeNode copy = new TreeNode(n.val);
            TreeNode node = new TreeNode(number);
            
            copy.left = n.left;
            copy.right = n.right;
            node.left = copy;
            result.add(node);
            return result;
        }
        else if(n.right != null && n.left == null){
            List<TreeNode> result = new ArrayList<TreeNode>();
            List<TreeNode> right = createTrees(n.right, number);
            
            for(int i = 0; i < right.size(); i ++){
                TreeNode newNode = new TreeNode(n.val);
              
                
                newNode.right = right.get(i);
              
                result.add(newNode);
                
            }
            TreeNode copy = new TreeNode(n.val);
            copy.right = n.right;
            TreeNode node = new TreeNode(number);
            node.left = copy;
            result.add(node);
            return result;
        }
        else if(n.right == null && n.left != null){
            TreeNode node = new TreeNode(n.val);
            node.left = n.left;
            TreeNode newNode = new TreeNode(number);
            newNode.left = node;
            TreeNode copy = new TreeNode(n.val);
            copy.left = n.left;
            copy.right = new TreeNode(number);
            
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(newNode);
            result.add(copy);
            return result;
        }
        else if(n.left == null && n.right == null){
            TreeNode node = new TreeNode(n.val);
            node.right = new TreeNode(number);
            TreeNode copy = new TreeNode(number);
            copy.left = new TreeNode(n.val);
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(copy);
            result.add(node);
            
            return result;
        }
        return null;
    }
    public List<TreeNode> generateTrees(int n) {
        TreeNode node = new TreeNode(1);
        
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if(n == 0){
            return nodes;
        }
        
        nodes.add(node);
        
        for(int i = 2; i <= n ;i++){
            List<TreeNode> temp = new ArrayList<TreeNode>();
            for(int j = 0; j < nodes.size(); j++){
                temp.addAll(createTrees(nodes.get(j), i));
            }
            nodes = temp;
        }
        //System.out.println(nodes.size());
        return nodes;
    }
}
