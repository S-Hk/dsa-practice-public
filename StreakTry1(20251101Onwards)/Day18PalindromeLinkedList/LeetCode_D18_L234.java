/*
234. Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/
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
    public boolean isPalindrome(ListNode head) {
        if(head==null  || head.next==null) return true;
        //find middle
        //1,2,<3>,2,1-odd
        //1,<2>,2,1-even
        ListNode mid  = head;
        ListNode fast = head;
        //boolean even = false;

        while(fast.next!=null && fast.next.next!=null){
            //even = even? false: true;
            mid = mid.next;
            fast = fast.next.next;            
        }

        //reverse after mid
        ListNode node = mid.next;
        ListNode prev = null;
        while(node!=null){
            ListNode temp = node.next;
            node.next=prev;
            prev = node;
            node = temp;
        }
        mid.next = prev;


        node = head; //node1 
        fast = mid.next; //node2
        while(fast!=null){
            if(node.val!=fast.val)
                return false;
            node = node.next;
            fast = fast.next;

        }
        //if(even){
        //}
        return true;
    }
}


/*
//using stack -
    //time-O(n)
    //space-O(n)
//most optimal -  needed  hints from the video on approach
    //time-O(n)
    //space-O(1)
*/