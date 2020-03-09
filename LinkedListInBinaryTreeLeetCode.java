/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {
    
    public boolean utilRecurse(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return head == null;
        if(root.val != head.val) return false;
        else return ( utilRecurse(head.next, root.left) || utilRecurse(head.next, root.right));
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean current = utilRecurse(head, root);
        if(current) return current;
        if(root != null) current =  (isSubPath(head, root.left) || isSubPath(head, root.right));
        return current;
               
    }
}
