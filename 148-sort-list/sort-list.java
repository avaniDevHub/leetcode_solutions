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
    //    Divide the linked list into two halves using the fast and slow pointer technique, recursively sort both halves, and merge the two sorted lists.Time Complexity: $\mathcal{O}(n \log n)$ — Splitting takes $\mathcal{O}(\log n)$ levels, and merging takes $\mathcal{O}(n)$ work per level.Space Complexity: $\mathcal{O}(\log n)$ — Recursion call stack depth.

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper function to merge two sorted linked lists
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummy.next;
    }

    // Main Merge Sort function
    public ListNode sortList(ListNode head) {
        // Base case: empty list or single element list
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find middle and split into two halves
        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        
        middle.next = null; // Disconnect left and right halves

        // Step 2: Recursively sort left and right halves
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        // Step 3: Merge sorted halves
        return mergeTwoLists(leftHead, rightHead);
    }
}