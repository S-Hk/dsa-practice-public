/*
Problem:
https://leetcode.com/problems/add-two-numbers/

2. Add Two Numbers
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || (l1.next==null && l1.val==0)) return l2;
        if(l2==null || (l2.next==null && l2.val==0)) return l1;
        int balance = 0;
        ListNode result = new ListNode(0);
        ListNode ans = result;
        
        while(l1!=null || l2!=null){
            if(l1!=null){
                result.val+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                result.val+=l2.val;
                l2=l2.next;
            }
            if(result.val>9){
                balance = 1;
                result.val =  result.val - 10;
                result.next = new ListNode(balance);
                balance = 0;
            }
            if(l1!=null || l2!=null){
                if(result.next==null){
                    result.next = new ListNode(0);
                }
                result=result.next;
            }
        }
        return ans;
    }
}