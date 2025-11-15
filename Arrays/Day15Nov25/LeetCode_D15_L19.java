/*
Problem:
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

19. Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0) return head;
        if(head ==null) return head;

        int length = 0;

        ListNode nd = head;

        for(int i=n; i>1; i--){
            if(nd.next==null) return head;
            nd = nd.next;
        }

        ListNode removeElement = head;
        ListNode lastElementBeforeRemoveElement =null;

        while(nd.next!=null){
            nd = nd.next;
            lastElementBeforeRemoveElement = removeElement;
            removeElement = removeElement.next;
        }
        if(lastElementBeforeRemoveElement==null)
            return head.next;
        else if(lastElementBeforeRemoveElement.next==null){
            return null;
        }

        lastElementBeforeRemoveElement.next =  lastElementBeforeRemoveElement.next.next;

        return head;
    }
}