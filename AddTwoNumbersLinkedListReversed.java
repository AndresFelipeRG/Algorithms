/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
        ListNode tempL1 = l1;
        ListNode tempL2 = l2;
        
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        
        ListNode revL1 =l1==null?null: new ListNode(l1.val);
        ListNode revL2 = l2 == null? null:new ListNode(l2.val);
        
        while(l1.next != null && l2.next != null){
           
            ListNode nodeL1 = new ListNode(l1.next.val);
            nodeL1.next = revL1;
            revL1 = nodeL1;
            
            ListNode nodeL2 = new ListNode(l2.next.val);
            nodeL2.next = revL2;
            revL2 = nodeL2;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode result = null;
        
        if(l1.next == null){
            int carry = 0;
            ListNode head = new ListNode(0);
            ListNode copy = head;
            while(tempL1 != null){
            
                int count = (tempL1.val + tempL2.val + carry)%10;
                carry = (tempL1.val + tempL2.val + carry)/10;
                ListNode node = new ListNode(count);
                copy.next = node;
                copy = node;
                tempL1 = tempL1.next;
                tempL2 = tempL2.next;
            }
            if(carry > 0){
                
                while(tempL2!=null){
                    int count = (tempL2.val + carry)%10;
                    carry = (tempL2.val+carry)/10;
                    ListNode node = new ListNode(count);
                    copy.next = node;
                    copy = node;
                    tempL2 = tempL2.next;
                }
                if(carry >0){
                    ListNode node = new ListNode(carry);
                    copy.next = node;
                    copy = node;
                }
            }
            else if(carry == 0){
            copy.next = tempL2;
            }
            result = head.next;
            return result;
        }
        
       else if(l2.next == null){
        
            int carry = 0;
            ListNode head = new ListNode(0);
            ListNode copy = head;
            while(tempL2 != null){
            
                int count = (tempL1.val + tempL2.val + carry)%10;
                carry = (tempL1.val + tempL2.val + carry)/10;
                ListNode node = new ListNode(count);
                copy.next = node;
                copy = node;
                tempL1 = tempL1.next;
                tempL2 = tempL2.next;
            }
            if(carry > 0){
                
                while(tempL1!=null){
                    int count = (tempL1.val + carry)%10;
                    carry = (tempL1.val+carry)/10;
                    ListNode node = new ListNode(count);
                    copy.next = node;
                    copy = node;
                    tempL1 = tempL1.next;
                }
                if(carry >0){
                    ListNode node = new ListNode(carry);
                    copy.next = node;
                    copy = node;
                }
            }
            else if(carry == 0){
            copy.next = tempL1;
            }
            result = head.next;
            return result;
        }
        return result;
    }
}
