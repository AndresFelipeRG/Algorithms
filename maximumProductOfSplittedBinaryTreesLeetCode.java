class Solution {
    long max = Integer.MIN_VALUE;
    int MOD = 1000000007;
    int s;
    public int maxProduct(TreeNode root) {
        s = sum(root);
        run(root);
        return (int)(max%MOD);
    }
    
    private int sum(TreeNode root) {
        if (root == null) return 0;
        
        root.val += sum(root.left) + sum(root.right);
        return root.val;
    }
    
    private void run(TreeNode root) {
        if (root == null)
            return;
        long rest = s - root.val;
        max = Math.max(max, (rest * root.val));
        run(root.left);
        run(root.right);
    }
}
