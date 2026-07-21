 class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        if (left == right) {
            return head;
        }

        ListNode t = head;
        ListNode before = null;
        int pos = 1;

        while (pos < left) {          // walk to the node just before 'left'
            before = t;
            t = t.next;
            pos++;
        }

        ListNode curr = t;
        ListNode prev = null;
        int times = right - left + 1;

        while (times > 0) {           // real part of the reversing
            ListNode temp = curr.next;  // storing curr.next
            curr.next = prev;           // fixed: was curr.temp
            prev = curr;                 // advancing prev
            curr = temp;                 // fixed: was curr = curr
            times--;                     // fixed: was missing entirely
        }

        t.next = curr;   // 't' is now the tail of the reversed segment

        if (before != null) {
            before.next = prev;
            return head;
        } else {
            return prev;   // left == 1: prev is the new head
        }
    }
}