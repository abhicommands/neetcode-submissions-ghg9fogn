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
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. Reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next= prev;
            prev = curr;
            curr = temp;
        }
        // 3. Merge
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
    //[0, 1, 2, 3, 4, 5, 6] 2x pointer.
    //[0->6->1->5->2->4->3]
    //[0, 6, 1, 5, 2, 4, 3]
    //[0, 1, 2, 3, 4, 5, 6, 7]
    //[1, 2, 2, 4, 3, 6]
    //[0->1->2->3->4<-5<-6-<7]
    //0->7->1->6->2->5->3->4
}
