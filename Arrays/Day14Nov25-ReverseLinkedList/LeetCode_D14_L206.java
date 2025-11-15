/*
Problem: 206. Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/
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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next ==null){
            return head;
        }

        ListNode temp = head;

        head = new ListNode();
        head.val = temp.val;
        head.next = null;
        
        while(temp.next !=null){
            temp = temp.next;
            ListNode tempHead = new ListNode();
            tempHead.val = head.val;
            tempHead.next = head.next;

            head.next = tempHead;
            head.val = temp.val;
        }
        return head;
    }
}
/*
1 2 3 4 5
1,2345
21
*/
//Solved, but forgot to commit