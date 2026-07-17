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
        // Create a dummy node that points to the head.
        // This handles edge cases like removing the head itself.
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;

        // Advance the 'first' pointer so that the gap between 
        // 'first' and 'second' is exactly n nodes apart.
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until 'first' reaches the end.
        // 'second' will now point to the node just before the one to be removed.
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the target node.
        second.next = second.next.next;

        // Return the actual head (skipping the dummy node).
        return dummy.next;
    }
}