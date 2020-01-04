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
    public int findSumUtil(TreeNode root, Map<Integer, Integer> counts){
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            counts.put(root.val, counts.getOrDefault(root.val,0)+1);
            return root.val;
        }
        int sum = root.val+ findSumUtil(root.left, counts) + findSumUtil(root.right, counts);
        counts.put(sum, counts.getOrDefault(sum,0) + 1);
        return sum;       
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[]{};
        int maxF = -1;
        ArrayList<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();
        findSumUtil(root, counts);
        for(Integer sum: counts.keySet()){
            if(counts.get(sum) > maxF){
                maxF = counts.get(sum) ;
            }
        }
        System.out.println(String.valueOf(counts));
        for(Integer sum: counts.keySet()) if(counts.get(sum) == maxF) arr.add(sum);
        int [] ans = new int[arr.size()];
        for(int i = 0; i < ans.length;i++) ans[i] = arr.get(i);
        return ans;
    }
}
