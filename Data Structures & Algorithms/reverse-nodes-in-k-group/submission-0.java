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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevTail = dummy;
        ListNode temp = head;

        while (temp != null) {
            ListNode kNode = getK(temp, k);

            if (kNode == null) {
                break;
            }

            ListNode kthNextNode = kNode.next;
            kNode.next = null;
            ListNode reverseHead = reverse(temp);
            prevTail.next = reverseHead;
            prevTail = temp;
            temp = kthNextNode;
            prevTail.next = temp;
        }
        return dummy.next;
    }


    public ListNode getK(ListNode head, int k) {
        if (head == null) return null;
        while (k > 1 && head != null) {
            head = head.next;
            k--;
        }
        return head;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
