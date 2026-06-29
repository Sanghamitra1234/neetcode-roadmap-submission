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

        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode answer = new ListNode(0);
        ListNode answer1 = answer;
        int carryOver = 0;
        while (l1 != null && l2 != null) {
            int a = carryOver + l1.val + l2.val;
            carryOver = a >= 10 ? 1 : 0;
            a = a % 10;

            answer.next = new ListNode(a);
            answer = answer.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int a = carryOver + l1.val;
            carryOver = a >= 10 ? 1 : 0;
            a = a % 10;

            answer.next = new ListNode(a);
            answer = answer.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int a = carryOver + l2.val;
            carryOver = a >= 10 ? 1 : 0;
            a = a % 10;

            answer.next = new ListNode(a);
            answer = answer.next;
            l2 = l2.next;
        }

        if (carryOver > 0) {
            answer.next = new ListNode(carryOver);
            answer = answer.next;
        }

        return answer1.next;
        
    }
}
