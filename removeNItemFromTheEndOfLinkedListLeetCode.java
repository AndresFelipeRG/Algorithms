/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode node = head;
        ListNode prev = null;
        ListNode res = null;
        while(node != null){
            ListNode temp  = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            if(node == null){
                res = prev;
                int count = 1;
                node = prev;
                if(n == 1){
                    res = node.next;
                    node = null;
                }else{
                    
                 while(count < n ){
                        prev = node;
                        node = node.next;
                        count+=1;
                 }
                 prev.next = node.next;
                 prev = node;
                 node = node.next;
                }
                
                node = res;
                prev = null;
                while(node != null){
                    
                    ListNode temp2 = node.next;
                    node.next = prev;
                    prev = node;
                    node = temp2;
                    
                }
                res = prev;
                break;
            }
        }
        
      
        return res;
    }
}
