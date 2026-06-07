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
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy; // the actual node will be this
        ListNode offset = head;
        while(n>0) {
            offset = offset.next;
            n--;
        }
        while(offset != null) {
            offset = offset.next;
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }
}
