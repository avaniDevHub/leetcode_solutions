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
    public ListNode sortList(ListNode head) {
        // 1. Brute Force (Array / ArrayList Extraction)Extract all node values into an array, sort the array using Java's built-in Arrays.sort(), and write the values back into the linked list.Time Complexity: $\mathcal{O}(n \log n)$ — Extracting takes $\mathcal{O}(n)$, sorting takes $\mathcal{O}(n \log n)$, and re-assigning takes $\mathcal{O}(n)$.Space Complexity: $\mathcal{O}(n)$ — Extra memory required for storing values in an array or list.

        if(head==null || head.next==null)
        {
            return head;
        }

        List<Integer> values= new ArrayList<>();
        ListNode curr= head;

        while(curr!= null)
        {
            values.add(curr.val);
            curr= curr.next;

        }

        Collections.sort(values);

        curr=head;
        for(int val:values)
        {
            curr.val=val;
            curr= curr.next;
        }
        return head;
    }
}