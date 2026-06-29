/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        Node deepcopy = new Node (0);
        Node deepcopy1 = deepcopy;
        Node curr = head;

        while (curr != null) {
            deepcopy.next = new Node (curr.val);
            deepcopy = deepcopy.next;
            oldToCopy.put(curr, deepcopy);
            curr = curr.next;
        }

        curr = head;
        deepcopy = deepcopy1.next;
        Node answer = deepcopy;
        while (curr != null) {
            deepcopy.random = oldToCopy.get(curr.random);
            deepcopy = deepcopy.next;
            curr = curr.next;
        }

        return answer;
    }
}
