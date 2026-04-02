class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            if(fast.next!=null)fast = fast.next;     // move 2 steps
            fast = fast.next;
            if (slow == fast) return true;
        }

        return false;
    }
}