/*
Problem:
https://leetcode.com/problems/middle-of-the-linked-list/

876. Middle of the Linked List
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
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next ==null) return head;

        ListNode ln = head;
        int length = 1;
        while(ln.next!=null){
            length++;
            ln = ln.next;
        }
        ln=head;
        for(int i=0; i<(length/2);i++){
            ln=ln.next;
        }
        return ln;
    }
}