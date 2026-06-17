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
        int carryOver = 0;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode currRes = dummy;
        int val;
        while (curr1 != null || curr2 != null) {
            if (curr1 == null) {
                val = curr2.val + carryOver;
                curr2 = curr2.next;
            } else if (curr2 == null) {
                val = curr1.val + carryOver;
                curr1 = curr1.next;
            } else {
                val = curr1.val + curr2.val + carryOver;
                curr2 = curr2.next;
                curr1 = curr1.next;
            }
            if (val > 9) {
                carryOver = 1;
                val -=10;
            } else carryOver = 0;
            currRes.next = new ListNode(val);
            currRes = currRes.next;
        }
        if (carryOver >0) {
            currRes.next = new ListNode(1);
            currRes = currRes.next;
        }
        return dummy.next;

    }
}
