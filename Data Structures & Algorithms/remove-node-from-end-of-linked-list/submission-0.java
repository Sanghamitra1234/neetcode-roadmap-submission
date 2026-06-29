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
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;


        while ( i <= n && slow != null) {
            slow = slow.next;
            i++;
        }
        if (slow == null && i <= n) {
            return head.next;
        }
        fast = slow;
        slow = head;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        } else {
            slow.next = null;
        }
        
        return head;
    }
}

