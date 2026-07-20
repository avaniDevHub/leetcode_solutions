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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;
        PriorityQueue<ListNode> minheap= new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for(ListNode node: lists)
        {
            if(node !=null)
            {
                minheap.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!minheap.isEmpty())
        {
            ListNode node = minheap.poll();
            current.next = node;
            current = current.next;
            // 3. If there is a next node in that specific list, push it to the heap
            if (node.next != null) {
                minheap.add(node.next);
            }
        }
        
        return dummy.next;
    }
}