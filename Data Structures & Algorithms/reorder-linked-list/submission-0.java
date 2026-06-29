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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = findMiddleNode(head);
        ListNode head2 = reverseLinkedList(mid.next);

        mid.next = null;

        ListNode dummy1 = head;
        ListNode dummy2 = head2;

        while (head2 != null) {

            dummy1 = head.next;
            dummy2 = head2.next;

            head.next = head2;
            head2.next = dummy1;

            head = dummy1;
            head2 = dummy2;
        }
        
    }

    public ListNode findMiddleNode(ListNode h) {
        ListNode slow = h;
        ListNode fast = h;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public ListNode reverseLinkedList (ListNode h) {
        ListNode prev = null;
        ListNode next = h;

        while (h != null) {
            next = h.next;
            h.next = prev;
            prev = h;
            h = next;
        }

        return prev;
    }
}
