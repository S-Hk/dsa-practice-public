/*
Problem: 141. Linked List Cycle
https://leetcode.com/problems/linked-list-cycle/description/
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow= head;
        ListNode fast= head;
        while(head!=null){
            if(slow.next==null)
                return false;
            if(fast.next==null||fast.next.next==null)
                return false;

            slow = slow.next;

            fast =fast.next.next;

            if(slow==fast)
                return true;

            
        }
        return false;
    }
}
/*
Solved problem on 17th, just missed to commit on same day here
 */